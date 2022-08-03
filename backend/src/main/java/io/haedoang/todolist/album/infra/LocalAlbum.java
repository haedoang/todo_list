package io.haedoang.todolist.album.infra;

import io.haedoang.todolist.album.application.dto.AlbumResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * author : haedoang
 * date : 2022-08-03
 * description :
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class LocalAlbum implements AlbumHandler {
    private final AtomicLong counter = new AtomicLong();
    private final String fileUploadPath;

    @Override
    public List<AlbumResponse> getList() {
        File uploadPath = new File(fileUploadPath);
        if (!uploadPath.isDirectory()) throw new AssertionError();
        return Arrays.stream(Objects.requireNonNull(uploadPath.listFiles()))
                .map(AlbumResponse::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public void upload(MultipartFile file) {
        File toSaveFile = new File(uploadFileName(fileUploadPath, file.getOriginalFilename()));
        log.info("toSaveFile: {}", toSaveFile.getAbsolutePath());

        try (OutputStream os = Files.newOutputStream(toSaveFile.toPath())){
            os.write(file.getBytes());
        } catch (IOException e) {
            log.error("upload failed : {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private String uploadFileName(String fileUploadPath, String originalFilename) {
        String baseName = FilenameUtils.getBaseName(originalFilename);
        String extension = FilenameUtils.getExtension(originalFilename);
        return fileUploadPath + baseName + "_" + counter.incrementAndGet() + "." + extension;
    }
}
