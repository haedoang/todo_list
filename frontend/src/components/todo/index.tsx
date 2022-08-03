
import { useState } from "react";
import { useQuery, useMutation, useQueryClient } from "react-query";
import List from 'antd/lib/list';
import Row from 'antd/lib/row';
import Typography from "antd/lib/typography";
import Col from 'antd/lib/col';
import TodoType from "types/TodoResponse";
import CheckOutlined from '@ant-design/icons/CheckOutlined';
import DeleteOutlined from '@ant-design/icons/DeleteOutlined';
import RedoOutlined from '@ant-design/icons/RedoOutlined';

import Input from 'antd/lib/input';
import { fetchTodoList, fetchUpdate, fetchDelete, fetchSave } from 'ApiUtils';

function Todo() {
    const queryClient = useQueryClient();
    const [text, setText] = useState('');
    const { isLoading, isError, data, refetch } = useQuery('getList', () => fetchTodoList());

    const { mutate: doComplete } = useMutation(fetchUpdate, {
        onSuccess: () => {
            queryClient.invalidateQueries('getList', { exact: true });
        }
    });

    const { mutate: doDelete } = useMutation(fetchDelete, {
        onSuccess: () => {
            queryClient.invalidateQueries('getList', { exact: true });
        }
    });

    const { mutate: doSave } = useMutation(fetchSave, {
        onSuccess: () => {
            queryClient.invalidateQueries('getList', { exact: true });
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
        <List
            bordered
            itemLayout="horizontal"
            dataSource={data}
            header={<RedoOutlined onClick={() => refetch()} />}
            footer={<Input onKeyDown={handleKeyDown} onChange={e => setText(e.target.value)} value={text} />}
            renderItem={(item: TodoType) => (
                <List.Item key={item.id}
                    actions={
                        [
                            <a onClick={() => doComplete(item.id)}><CheckOutlined /></a>,
                            <a onClick={() => doDelete(item.id)}><DeleteOutlined /></a>
                        ]
                    }
                >
                    <Typography.Text delete={item.completed}>{item.content}</Typography.Text>
                </List.Item>
            )}
        />
    );
}

export default Todo;