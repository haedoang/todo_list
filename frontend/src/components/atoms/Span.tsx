import styled from'styled-components';

export interface SpanProps {
    fontSize?: string;
    fontWeight?: string;
    color?: string;
    width?: string;
    height?: string;
    margin?: string;
}

const Span = styled.span<SpanProps>`
    font-size: ${props => props.fontSize};
    font-weight: ${props => props.fontWeight};
    color: ${props => props.color};
    width : ${props => props.width};
    height: ${props => props.height};
    margin: ${props => props.margin};
`

export default Span;