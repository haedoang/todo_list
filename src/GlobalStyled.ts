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
    .pointer {
        cursor : pointer;
    }

    //::-webkit-scrollbar { display: none; }

    .hidden ::::-webkit-scrollbar {
        display : none;
    }

    .ant-table-column-title { z-index : 0 }
    
    .active-table {
        background-color: #95a5a6;
    }

    .ant-table table { font-size: 12px; font-weight: 500 }

    .ant-table-tbody > tr > td {
        height: 5px;
        padding: 4px;
        vertical-align: middle;
    }
    
    .ant-table-thead > tr > th {
        height: 5px;
        padding: 4px;
    }

    .ant-table:hover {
        cursor: pointer;
    }

    .ant-table-tbody > tr.ant-table-row:hover > td {
        background-color: #95a5a6;
    } 
     
    pre {
        white-space: pre-wrap;       /* Since CSS 2.1 */
        white-space: -moz-pre-wrap;  /* Mozilla, since 1999 */
        white-space: -pre-wrap;      /* Opera 4-6 */
        white-space: -o-pre-wrap;    /* Opera 7 */
        word-wrap: break-word;       /* Internet Explorer 5.5+ */
    }
`;

export default GlobalStyles;
