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
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class TodoRequest {
    private String content;


    public static TodoRequest valueOf(String content) {
        return new TodoRequest(content);
    }

    public Todo toEntity() {
        return Todo.valueOf(content);
    }
}
