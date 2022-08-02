package io.haedoang.todolist.todo.application.dto;

import io.haedoang.todolist.todo.domain.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

/**
 * author : haedoang
 * date : 2022-08-02
 * description :
 */
@Getter
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PRIVATE)
public class TodoResponse {
    private Long id;
    private String content;
    private boolean isCompleted;

    public static TodoResponse valueOf(Todo entity) {
        return new TodoResponse(entity.getId(), entity.getContent(), entity.getStatus().isFinished());
    }
}
