import { createGlobalStyle } from "styled-components";
import reset from "styled-reset";

const GlobalStyles = createGlobalStyle`
    ${reset};
    a {
        text-decoration : none;
        color : inherit;
    },
    * {
        box-sizing : border-box;
    }
    body {
        font-family : -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
        font-size : 12px;
        background-color : #e9e9ed;
        -ms-overflow-style: none; 
        padding-top: 50px;
    }
`;

export default GlobalStyles;
