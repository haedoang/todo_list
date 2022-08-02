package io.haedoang.todolist.todo.infra;

import io.haedoang.todolist.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author : haedoang
 * date : 2022-08-02
 * description :
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
