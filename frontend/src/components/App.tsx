import { useQuery, useMutation, useQueryClient } from "react-query";
import axios from 'axios';
import List from 'antd/lib/list';
import Row from 'antd/lib/row';
import Typography from "antd/lib/typography";
import Col from 'antd/lib/col';
import TodoType from "types/TodoResponse";
import CheckOutlined from '@ant-design/icons/CheckOutlined';
import DeleteOutlined from '@ant-design/icons/DeleteOutlined';

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


function App() {
    const queryClient = useQueryClient();
    const { isLoading, isError, data } = useQuery('getList', () => fetchList());
    
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

    const doSave = () => {
        ;;
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