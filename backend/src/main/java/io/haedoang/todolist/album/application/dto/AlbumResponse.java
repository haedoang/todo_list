package io.haedoang.todolist.album.application.dto;

import io.haedoang.todolist.album.domain.Album;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.sql.Timestamp;
import java.time.ZoneId;

/**
 * author : haedoang
 * date : 2022-08-03
 * description :
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AlbumResponse {
    private String fileName;
    private long lastModified;

    public static AlbumResponse valueOf(File file) {
        return new AlbumResponse(file.getName(), file.lastModified());
    }

    public static AlbumResponse valueOf(Album entity) {
        return new AlbumResponse(entity.getFileName(), entity.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }
}
