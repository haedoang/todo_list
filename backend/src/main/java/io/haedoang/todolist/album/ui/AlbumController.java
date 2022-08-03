package io.haedoang.todolist.album.ui;

import io.haedoang.todolist.album.application.AlbumService;
import io.haedoang.todolist.album.application.dto.AlbumResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * author : haedoang
 * date : 2022-08-03
 * description :
 */
@Slf4j
@RestController
@RequestMapping("api/v1/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;


    @GetMapping
    public ResponseEntity<List<AlbumResponse>> findAll() {
        List<AlbumResponse> response = albumService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<Void> fileUpload(@RequestParam(required = false) MultipartFile file) {
        albumService.upload(file);
        return ResponseEntity.ok().build();
    }

}
