package io.haedoang.todolist.album.infra;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import io.haedoang.todolist.album.application.dto.AlbumResponse;
import io.haedoang.todolist.album.domain.Album;
import io.haedoang.todolist.album.domain.AlbumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * author : haedoang
 * date : 2022-08-08
 * description :
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class S3AlbumHandler implements AlbumHandler {
    public static final String dirName = "albums";

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    private final AmazonS3Client amazonS3Client;
    private final AlbumRepository albumRepository;

    @Override
    public List<AlbumResponse> getList() {
        return albumRepository.findAll()
                .stream().map(AlbumResponse::valueOf)
                .collect(toList());
    }

    @Override
    public void upload(MultipartFile file) {
        String uploadedFileName = putS3(file);
        Album album = Album.valueOf(uploadedFileName);
        albumRepository.save(album);
    }

    private String putS3(MultipartFile file) {
        try {
            String uploadFileName = dirName + "/" + UUID.randomUUID() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());

            PutObjectResult result = amazonS3Client.putObject(
                    new PutObjectRequest(bucketName, uploadFileName, file.getInputStream(), objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead));

            log.info("putS3 result: {}", result);
            return amazonS3Client.getUrl(bucketName, uploadFileName).toString();
        } catch (IOException e) {
            return "";
        }
    }
}
