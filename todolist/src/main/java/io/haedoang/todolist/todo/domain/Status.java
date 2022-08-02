package io.haedoang.todolist.todo.domain;

/**
 * author : haedoang
 * date : 2022-08-02
 * description :
 */
public enum Status {
    NOT_FINISHED, FINISHED;

    public boolean isNotFinished() {
        return this == NOT_FINISHED;
    }

    public boolean isFinished() {
        return this == FINISHED;
    }
}
