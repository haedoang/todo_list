import { useQuery, useQueryClient } from "react-query";
import { fetchAlbumList } from "ApiUtils";
import type { UploadProps } from "antd/lib/upload";
import Upload from 'antd/lib/upload';
import message from 'antd/lib/message';
import InboxOutlined from '@ant-design/icons/InboxOutlined';
const { Dragger } = Upload;

function Album() {
    const queryClient = useQueryClient();
    const { isLoading, isError, data, refetch } =
        useQuery('getAlbumList', () => fetchAlbumList());

        const draggerProps: UploadProps = {
            name: 'file',
            multiple: true,
            action: 'http://localhost:8080/api/v1/albums',
            onChange(info) {
                const { status } = info.file;
                if (status !== 'uploading') {
                    console.log(info.file, info.fileList);
                    queryClient.invalidateQueries('getAlbumList', { exact: true });
                }
                if (status === 'done') {
                    message.success(`${info.file.name} file uploaded successfully.`);
                } else if (status === 'error') {
                    message.error(`${info.file.name} file upload failed.`);
                }
            },
            onDrop(e) {
                console.log('Dropped files', e.dataTransfer.files);
            },
        
        };

    return (
        <>
            <Dragger {...draggerProps}>
                <p className="ant-upload-drag-icon">
                    <InboxOutlined />
                </p>
                <p className="ant-upload-text">Click or drag file to this area to upload</p>
                <p className="ant-upload-hint">
                    Support for a single or bulk upload. Strictly prohibit from uploading company data or other
                    band files
                </p>
            </Dragger>
            {
                isLoading ? <div>loading..</div>
                : isError ? <div>album list request failed</div>
                : <div>{JSON.stringify(data)}</div>
            }
        </>
    );
}

export default Album;