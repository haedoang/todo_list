package io.haedoang.todolist.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author : haedoang
 * date : 2022-08-05
 * description :
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
