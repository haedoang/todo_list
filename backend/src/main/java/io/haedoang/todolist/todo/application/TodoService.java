package io.haedoang.todolist.todo.application;


import io.haedoang.todolist.todo.application.dto.TodoRequest;
import io.haedoang.todolist.todo.application.dto.TodoResponse;
import io.haedoang.todolist.todo.domain.Todo;
import io.haedoang.todolist.todo.exception.TodoNotExistException;
import io.haedoang.todolist.todo.infra.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * author : haedoang
 * date : 2022-08-02
 * description :
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public TodoResponse save(TodoRequest request) {
        Todo todo = request.toEntity();
        Todo actual = todoRepository.save(todo);
        return TodoResponse.valueOf(actual);
    }

    public List<TodoResponse> list() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponse::valueOf)
                .collect(Collectors.toList());
    }

    @Transactional
    public void changeStatus(Long id) {
        findById(id).updateStatus();
    }

    @Transactional
    public void delete(Long id) {
        findById(id).doDelete();
    }


    public Todo findById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(TodoNotExistException::new);
    }
}
