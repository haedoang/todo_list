import type { UploadProps } from "antd/lib/upload";
import Upload from 'antd/lib/upload';
import InboxOutlined from '@ant-design/icons/InboxOutlined';
const { Dragger } = Upload;

export interface AlbumUploaderProps {
    draggerProps: UploadProps;
}

function AlbumUploader({ draggerProps }: AlbumUploaderProps) {

    return (
        <Dragger {...draggerProps}>
            <p className="ant-upload-drag-icon">
                <InboxOutlined />
            </p>
            <p className="ant-upload-text">Click or drag file to this area to upload</p>
            <p className="ant-upload-hint">
                Support for a single or bulk upload.
            </p>
        </Dragger>
    )
}

export default AlbumUploader;