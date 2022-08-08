package io.haedoang.todolist.todo.domain;

import io.haedoang.todolist.base.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static io.haedoang.todolist.todo.domain.Status.FINISHED;
import static io.haedoang.todolist.todo.domain.Status.NOT_FINISHED;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

/**
 * author : haedoang
 * date : 2022-08-02
 * description :
 */
@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(name = "tb_todo")
@SQLDelete(sql = "UPDATE tb_todo SET deleted = true where id=?")
@Where(clause = "deleted=false")
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    private Status status = NOT_FINISHED;

    private final LocalDateTime createdAt = LocalDateTime.now();

    public Todo(String content) {
        validate(content);
        this.content = content;
    }

    public static Todo valueOf(String content) {
        return new Todo(content);
    }

    private void validate(String content) {
        if (StringUtils.isEmpty(content)) {
            throw new IllegalArgumentException();
        }
    }

    public void updateStatus() {
        this.status = status.isFinished() ? NOT_FINISHED : FINISHED;
    }
}
