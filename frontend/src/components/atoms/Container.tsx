import styled from "styled-components";

export interface ContainerProps {
  top?: string;
  left?: string;
  width?: string;
  height?: string;
  padding?: string;
  margin?: string;
  position?: string;
  display?: string;
  justifyContent?: string;
  justifyItems?: string;
  color?: string;
  bgColor?: string;
  alignItems?: string;
  zIndex?: string;
  border?: string;
  borderRadius?: string;
  boxShadow?: string;
  maxWidth?: string;
  flexDirection?: string;
  flexWrap?: string;
  overflow?: string;
  overflowX?: string;
  overflowY?: string;
  lineHeight?: string;
  opacity?: string;
}

const Container = styled.div<ContainerProps>`
  top: ${(props) => props.top};
  left: ${(props) => props.left};
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  padding: ${(props) => props.padding};
  margin: ${(props) => props.margin};
  position: ${(props) => props.position};
  display: ${(props) => props.display};
  justify-content: ${(props) => props.justifyContent};
  justify-items: ${(props) => props.justifyItems};
  color: ${(props) => props.color};
  background-color: ${(props) => props.bgColor};
  align-items: ${(props) => props.alignItems};
  z-index: ${(props) => props.zIndex};
  border: ${(props) => props.border};
  border-radius: ${(props) => props.borderRadius};
  box-shadow: ${(props) => props.boxShadow};
  max-width: ${(props) => props.maxWidth};
  justify-items: ${(props) => props.justifyItems};
  flex-wrap: ${(props) => props.flexWrap};
  overflow: ${props => props.overflow};
  overflow-x: ${props => props.overflowX};
  overflow-y: ${props => props.overflowY};
  line-height: ${props => props.lineHeight};
  opacity: ${props => props.opacity};
`;

export default Container;
