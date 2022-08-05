import styled from 'styled-components';

export interface ListProps {
    display?: string;
    bgColor?: string;
    padding?: string;
    gridTemplateColumns?:string;
    gridTemplateRows?:string;
    rowGap?:string;
    columnGap?:string;
    margin?:string;
    justifyContent?: string;
    flexDirection?: string;
}

export interface ItemProps {
    border?: string;
    borderBottom?: string;
    transition?: string;
    padding?: string;
    display?:  string;
    aliginItems?: string
    justifyContent? : string;
}

export const List = styled.ul<ListProps>`
    display: ${props => props.display};
    background-color: ${props => props.bgColor};
    padding: ${props => props.padding};
    grid-template-columns : ${props => props.gridTemplateColumns};
    grid-template-rows : ${props => props.gridTemplateRows};
    row-gap : ${props => props.rowGap};
    column-gap : ${props => props.columnGap};
    margin : ${props => props.margin};
    justify-content : ${props => props.justifyContent};
    flex-direction :  ${props => props.flexDirection};
`;

export const Item = styled.li<ItemProps>`
    border: ${props => props.border};
    border-bottom: ${props => props.borderBottom};
    transition: ${props => props.transition};
    padding: ${props => props.padding};
    display: ${props => props.display};
    align-items: ${props => props.aliginItems};
    justify-content: ${props => props.justifyContent};
`

