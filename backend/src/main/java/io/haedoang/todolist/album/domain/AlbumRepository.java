package io.haedoang.todolist.album.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author : haedoang
 * date : 2022-08-08
 * description :
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
