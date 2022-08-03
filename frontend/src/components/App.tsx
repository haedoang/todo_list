import Todo from 'components/todo';
import Album from 'components/album';
import Row from 'antd/lib/row';
import Col from 'antd/lib/col';

function App() {
    return (
        <Row justify='center'>
            <Col style={{ padding: "0 5px"}} >
                <Todo />
            </Col>
            <Col style={{ padding: "0 5px"}}>
                <Album />
            </Col>
        </Row>
    )
}

export default App;