import { useState } from "react";
import { useQuery, useMutation, useQueryClient } from "react-query";
import axios from 'axios';
import List from 'antd/lib/list';
import Row from 'antd/lib/row';
import Typography from "antd/lib/typography";
import Col from 'antd/lib/col';
import TodoType from "types/TodoResponse";
import CheckOutlined from '@ant-design/icons/CheckOutlined';
import DeleteOutlined from '@ant-design/icons/DeleteOutlined';
import RedoOutlined from '@ant-design/icons/RedoOutlined';
import Input from 'antd/lib/input';
import { isTypeAliasDeclaration } from "typescript";

const API = axios.create({
    baseURL: '/api/v1/',
    headers: { "Content-Type": "application/json; charset=UTF-8", Accept: "*/*" },
    timeout: 5000
});



const fetchList = () => {
    return API.get('todos')
        .then((res) => res.data);
}

const fetchComplete = (id: number) => {
    return API.patch(`todos/${id}`);
}

const fetchDelete = (id: number) => {
    return API.delete(`todos/${id}`);
}

const fetchSave = (todo: string) => {
    console.log('??')
    return API.post('todos', { "content" : todo});
}

function App() {
    const queryClient = useQueryClient();
    const [text, setText] = useState('');
    const { isLoading, isError, data, refetch } = useQuery('getList', () => fetchList());
    
    const { mutate: doComplete } = useMutation(fetchComplete, {
        onSuccess: () => {
            queryClient.invalidateQueries('getList', {exact : true});
        }
    });

    const { mutate: doDelete } = useMutation(fetchDelete, {
        onSuccess: () => {
            queryClient.invalidateQueries('getList', {exact : true});
        }
    });

    const { mutate: doSave } = useMutation(fetchSave, {
        onSuccess: () => {
            queryClient.invalidateQueries('getList', {exact : true});
            setText("");
        }
    })

    const handleKeyDown = (e: any) => {
        if (e.keyCode === 13) {
            doSave(text);
        }
    }

    if (isLoading) return <div>loading...</div>
    else if (isError) return <div>error</div>
    else return (
        <Row>
            <Col span={12} offset={6}>
                <List
                    bordered
                    itemLayout="horizontal"
                    dataSource={data}
                    header={<RedoOutlined onClick={() => refetch()}/>}
                    footer={<Input onKeyDown={handleKeyDown} onChange={e => setText(e.target.value)} value={text}/>}
                    renderItem={(item: TodoType) => (
                        <List.Item key={item.id}
                            actions={[
                                <a onClick={() => doComplete(item.id)} style={{ display: item.completed ? 'none' : 'block' }}><CheckOutlined /></a>,
                                <a onClick={() => doDelete(item.id)}><DeleteOutlined/></a>]
                            }
                        >
                            <Typography.Text delete={item.completed}>{item.content}</Typography.Text>
                        </List.Item>
                    )}
                />
            </Col>
        </Row>
    );
}

export default App;