package io.haedoang.todolist.todo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author : haedoang
 * date : 2022-08-02
 * description :
 */
@DisplayName("Todo 도메인 테스트")
class TodoTest {

    @Test
    @DisplayName("TODO 생성")
    public void create() {
        // given
        Todo todo = Todo.valueOf("빨래 널기!!");

        // then
        assertThat(todo.getContent()).isEqualTo("빨래 널기!!");
        assertThat(todo.getCreatedAt()).isNotNull();
        assertThat(todo.isDeleted()).isFalse();
        assertThat(todo.getStatus().isNotFinished()).isTrue();
    }
}
