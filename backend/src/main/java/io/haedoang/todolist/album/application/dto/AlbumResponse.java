package io.haedoang.todolist.album.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    public static AlbumResponse valueOf(String fileName) {
        return new AlbumResponse(fileName);
    }
}
