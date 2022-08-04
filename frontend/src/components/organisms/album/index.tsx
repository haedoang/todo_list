import { useQuery, useQueryClient } from "react-query";
import { fetchAlbumList } from "utils/ApiUtils";
import type { UploadProps } from "antd/lib/upload";
import message from 'antd/lib/message';
import AlbumUploader from 'components/molecules/album/AlbumUploader';
import AlbumViewer from 'components/molecules/album/AlbumViewer';

function Album() {
    const queryClient = useQueryClient();
    const { isLoading, isError, data } = useQuery('getAlbumList', () => fetchAlbumList());

    const draggerProps: UploadProps = {
        name: 'file',
        multiple: true,
        action: 'api/v1/albums',
        beforeUpload: file => {
            const isImage = file.type.includes('image');
            console.log('isImage', isImage);
            return isImage;
        },
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
        style: { maxHeight: 270, marginBottom: 20 }

    };

    return (
        <>
            <AlbumUploader draggerProps={draggerProps} />
            {
                isLoading ? <div>loading..</div>
                    : isError ? <div>album list request failed</div>
                        : <AlbumViewer data={data} />
            }
        </>
    );
}

export default Album;