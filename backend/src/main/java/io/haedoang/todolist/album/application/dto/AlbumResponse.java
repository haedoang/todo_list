package io.haedoang.todolist.album.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;

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
}
