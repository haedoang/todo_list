package io.haedoang.todolist.album.domain;

import io.haedoang.todolist.base.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

/**
 * author : haedoang
 * date : 2022-08-08
 * description :
 */
@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(name = "tb_album")
@SQLDelete(sql = "UPDATE tb_album SET deleted = true where id=?")
@Where(clause = "deleted=false")
public class Album extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String fileName;

    private Long userId;

    private Album(String fileName, Long userId) {
        this.fileName = fileName;
        this.userId = userId;
    }

    public static Album valueOf(String fileName) {
        return new Album(fileName, 1L);
    }
}
