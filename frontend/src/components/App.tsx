import { useState } from 'react';
import Main from 'components/pages/Main';
import Login from 'components/pages/Login';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from './pages/layout/Header';
import { getCookie } from 'utils/CookieUtils';
import LoginTest from 'components/pages/Login/LoginTest';

function App() {
    const [token, setToken] = useState(getCookie('thisistoken'));

    // if (!token) {
    //     return <Login setToken={setToken} />
    // }
    return (
        <BrowserRouter>
            <Header username="haedoang" />
            <Routes>
                <Route path="/" element={<Login setToken={token} />} />
                <Route path="/oauth2/redirect" element={<LoginTest />} />
            </Routes>
        </BrowserRouter>
    )
}

export default App;