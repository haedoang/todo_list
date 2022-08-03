package io.haedoang.todolist.upload.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicLong;

/**
 * author : haedoang
 * date : 2022-08-03
 * description :
 */
@Slf4j
@RestController
@RequestMapping("api/v1/uploads")
@RequiredArgsConstructor
public class UploadController {

    @Value("${spring.servlet.multipart.location}")
    private String fileUploadPath;
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public ResponseEntity<Void> fileUpload(@RequestParam(required = false) MultipartFile file) {
        File toSaveFile = new File(uploadFileName(fileUploadPath, file.getOriginalFilename()));
        log.info("toSaveFile: {}", toSaveFile.getAbsolutePath());

        try (OutputStream os = Files.newOutputStream(toSaveFile.toPath())){
            os.write(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().build();
    }

    private String uploadFileName(String fileUploadPath, String originalFilename) {
        String baseName = FilenameUtils.getBaseName(originalFilename);
        String extension = FilenameUtils.getExtension(originalFilename);
        return fileUploadPath + baseName + "_" + counter.incrementAndGet() + "." + extension;
    }
}
