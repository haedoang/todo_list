import Todo from 'components/organisms/todo';
import Album from 'components/organisms/album';
import Row from 'antd/lib/row';
import Col from 'antd/lib/col';

function Main() {
    return (
        <Row>
            <Col span={12} style={{ padding: "0 5px" }} >
                <Todo />
            </Col>
            <Col span={12} style={{ padding: "0 5px" }}>
                <Album />
            </Col>
        </Row>
    );
}

export default Main;
