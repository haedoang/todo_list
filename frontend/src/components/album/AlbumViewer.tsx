import AlbumType from 'types/AlbumResponse';
import Card from "antd/lib/card";
import ImageContainer from 'components/ImageContainer';
import Row from 'antd/lib/row';
import Col from 'antd/lib/col';

export interface AlbumProps {
    data: AlbumType[]
}

function AlbumViewer({ data }: AlbumProps) {
    const imageUrl = (fileName: string) => "images/" + fileName;

    return (
        <Row>
            <Col style={{ display: "grid", gap: "150px", gridTemplateColumns: "repeat(auto-fill, 80px)" }}>
                {
                    data.length > 0 &&
                    data.slice()
                        .map((album: AlbumType, index: number) => (
                            <Card
                                key={index}
                                hoverable
                                style={{ width: 200 }}
                                cover={
                                    <ImageContainer width="100%" height="300px" imageUrl={imageUrl(album.fileName)} />
                                }
                            >
                                <Card.Meta
                                    // title={wine.name}
                                    description="www.haedoang.io"
                                />
                            </Card>
                        ))
                }
            </Col>
        </Row>
    );
}

export default AlbumViewer;