package io.haedoang.todolist.todo.infra;

import io.haedoang.todolist.todo.domain.Todo;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author : haedoang
 * date : 2022-08-02
 * description :
 */
@DisplayName("Todo 리파지토리 테스트")
@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    @DisplayName("TODO 생성하기")
    public void create() {
        // given
        Todo todo = Todo.valueOf("빨래 널기!!");

        // when
        Todo actual = todoRepository.save(todo);

        // then
        assertThat(actual.getId()).isNotNull();
    }

    @Test
    @DisplayName("TODO 조회하기")
    public void search() {
        // given
        todoRepository.saveAll(
                Lists.newArrayList(
                        Todo.valueOf("todo1"),
                        Todo.valueOf("todo2")
                )
        );

        // when
        List<Todo> actual = todoRepository.findAll();

        // then
        assertThat(actual).hasSize(2);
    }

    @Test
    @DisplayName("TODO 조회하기2 - SoftDelete")
    public void searchWithoutDeleted() {
        // given
        Todo todo1 = Todo.valueOf("todo1");
        Todo todo2 = Todo.valueOf("todo2");

        todoRepository.saveAll(
                Lists.newArrayList(todo1, todo2)
        );

        todoRepository.deleteById(todo1.getId());

        // when
        List<Todo> actual = todoRepository.findAll();

        // then
        assertThat(actual).hasSize(1);
    }
}
