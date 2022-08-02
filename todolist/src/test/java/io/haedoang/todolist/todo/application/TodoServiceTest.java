package io.haedoang.todolist.todo.application;

import io.haedoang.todolist.todo.application.dto.TodoRequest;
import io.haedoang.todolist.todo.application.dto.TodoResponse;
import io.haedoang.todolist.todo.domain.Todo;
import io.haedoang.todolist.todo.infra.TodoRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * author : haedoang
 * date : 2022-08-02
 * description :
 */
@DisplayName("Todo 서비스 테스트")
@ExtendWith(MockitoExtension.class)
class TodoServiceTest {
    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    @DisplayName("TODO 생성 테스트")
    public void create() {
        // given
        TodoRequest request = TodoRequest.valueOf("todo1");
        when(todoRepository.save(any())).thenReturn(Todo.valueOf("todo1"));

        // when
        TodoResponse actual = todoService.save(request);

        // then
        assertThat(actual.getContent()).isEqualTo("todo1");
    }

    @Test
    @DisplayName("리스트 조회하기")
    public void list() {
        // given
        when(todoRepository.findAll()).thenReturn(
                Lists.newArrayList(
                        Todo.valueOf("todo1"), Todo.valueOf("todo2")
                )
        );

        // when
        List<TodoResponse> actual = todoService.list();

        // then
        assertThat(actual).hasSize(2);
    }
}
