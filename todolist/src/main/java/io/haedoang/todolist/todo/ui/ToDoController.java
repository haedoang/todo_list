package io.haedoang.todolist.todo.ui;

import io.haedoang.todolist.todo.application.TodoService;
import io.haedoang.todolist.todo.application.dto.TodoRequest;
import io.haedoang.todolist.todo.application.dto.TodoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

/**
 * author : haedoang
 * date : 2022-08-02
 * description :
 */
@RestController
@RequestMapping("api/v1/todos")
@RequiredArgsConstructor
public class ToDoController {
    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoResponse>> findAll() {
        List<TodoResponse> response = todoService.list();
        return ResponseEntity.ok()
                .body(response);
    }

    @PostMapping
    public ResponseEntity<TodoResponse> save(@RequestBody TodoRequest request) {
        TodoResponse response = todoService.save(request);
        return ResponseEntity.created(URI.create("api/v1/todos/" + response.getId()))
                .body(response);
    }
}
