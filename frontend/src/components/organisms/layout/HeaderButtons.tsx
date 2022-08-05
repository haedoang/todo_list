import { useEffect, useState } from "react";
import { getCookie, removeCookie, setCookie } from 'utils/CookieUtils';
import { List, Item, ItemProps } from "components/atoms/List";
import Span from 'components/atoms/Span';
import Avartar from 'antd/lib/avatar';
import Image from 'antd/lib/image';
import LogoutOutlined from '@ant-design/icons/LogoutOutlined';

const itemProps: ItemProps = {
    padding: '5px',
    display: "flex",
    aliginItems: "center",
};

function HeaderButtons() {
    const handleLogout = () => {
        removeCookie('username', { path: "/", });
        removeCookie('email', { path: "/", });
        removeCookie('profile_image_url', { path: "/", });
        window.location.reload();
    };


    useEffect(() => {
        console.log('getCookie', getCookie('email'));
    }, [])

    return (
        <List display="flex">
            <Item {...itemProps}>
                <Avartar src={<Image src={getCookie('profile_image_url')} />} />
            </Item>
            <Item {...itemProps}>
                {
                    getCookie('email') && <LogoutOutlined onClick={handleLogout} />
                }
            </Item>
        </List>
    );
}

export default HeaderButtons;
