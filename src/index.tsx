import ReactDOM from "react-dom";
import AppWrapper from "components/AppWrapper";
import GlobalStyles from "GlobalStyled";
import { ThemeProvider } from "styled-components";
import { lightTheme, darkTheme } from "theme";
import "antd/dist/antd.css";

ReactDOM.render(
  <ThemeProvider theme={lightTheme}>
    <AppWrapper />
    <GlobalStyles />
  </ThemeProvider>,
  document.getElementById("root")
);
