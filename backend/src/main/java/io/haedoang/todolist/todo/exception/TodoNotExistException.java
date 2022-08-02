package io.haedoang.todolist.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * author : haedoang
 * date : 2022-08-02
 * description :
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TodoNotExistException extends RuntimeException{
}
