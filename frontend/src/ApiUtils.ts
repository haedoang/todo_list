import axios from 'axios';

const API = axios.create({
    baseURL: '/api/v1/',
    headers: { "Content-Type": "application/json; charset=UTF-8", Accept: "*/*" },
    timeout: 5000
});

export const fetchTodoList = () => {
    return API.get('todos')
        .then((res) => res.data);
}

export const fetchUpdate = (id: number) => {
    return API.patch(`todos/${id}`);
}

export const fetchDelete = (id: number) => {
    return API.delete(`todos/${id}`);
}

export const fetchSave = (todo: string) => {
    return API.post('todos', { "content" : todo});
}