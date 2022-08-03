package io.haedoang.todolist.album.infra;

import io.haedoang.todolist.album.application.dto.AlbumResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * author : haedoang
 * date : 2022-08-03
 * description :
 */
public interface AlbumHandler {
    List<AlbumResponse> getList();
    void upload(MultipartFile file);
}
