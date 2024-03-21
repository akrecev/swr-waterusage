package ru.rosniivh.swr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rosniivh.swr.domain.auth.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public UserEntity findByUsername(String username);

    public UserEntity findByGisUserId(Integer gisUserId);
}
