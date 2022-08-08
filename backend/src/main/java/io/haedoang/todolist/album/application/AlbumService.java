package io.haedoang.todolist.album.application;

import io.haedoang.todolist.album.application.dto.AlbumResponse;
import io.haedoang.todolist.album.infra.AlbumHandler;
import io.haedoang.todolist.album.infra.S3AlbumHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * author : haedoang
 * date : 2022-08-03
 * description :
 */
@Service
@RequiredArgsConstructor
public class AlbumService {
    private final S3AlbumHandler handler;
    public List<AlbumResponse> findAll() {
        return handler.getList();
    }

    public void upload(MultipartFile file) {
        handler.upload(file);
    }
}
