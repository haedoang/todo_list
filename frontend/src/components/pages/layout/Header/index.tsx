
import ImageContainer, { ImageContainerProps } from "components/atoms/ImageContainer";
import Container, { ContainerProps } from "components/atoms/Container";

const headerContainerProps: ContainerProps = {
  top: "0",
  width:'100%',
  height: "50px",
  display: "flex",
  justifyContent: "space-between",
  color: "#ffffff",
  bgColor: "#242c4c",
  boxShadow: "0px 1px 5px 2px rgba(0,0,0,0.8);",
  zIndex: "1",
  alignItems: "center",
  position: "fixed",
};

const imageContainerProps: ImageContainerProps = {
  width: "150px",
  height: "50px",
  imageUrl: require("assets/logo.png").default
};

interface HeaderProps {
  username: string;
}

function Header({ username }: HeaderProps) {
  return (
    <Container as="header" {...headerContainerProps}>
      <ImageContainer as="a" href="/" {...imageContainerProps} />
    </Container>
  );
}

export default Header;