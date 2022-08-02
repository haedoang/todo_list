import { useQuery } from "react-query";
import axios from 'axios';

const API = axios.create({
    baseURL : '/api/v1',
    headers: { "Content-Type": "application/json; charset=UTF-8", Accept: "*/*" },
    timeout: 5000
});

const getList = () => {
    return API.get('/todos')
    .then((res) => res.data);
}

function App() {
    const { isLoading, isError, error, data} = useQuery('getList', () => getList());
    
    if (isLoading) return <div>loading...</div>
    else if (isError) return <div>error</div>
    else return (
        <div>
            {JSON.stringify(data)};
        </div>
    )   
}

export default App;