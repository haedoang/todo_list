import styled from 'styled-components';


export interface ImageContainerProps {
    imageUrl: string,
    width: string,
    height: string
}

const ImageContainer = styled.div<ImageContainerProps>`
    width: ${(props) => props.width};
    height: ${(props) => props.height};
    background-image: url(${(props) => props.imageUrl});
    background-repeat: no-repeat;
    background-position: center center;
    background-size: contain;
`;

export default ImageContainer;