package com.location.management.repository;

import com.location.management.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByEmailAndPassword(String email, String password);
    public UserEntity findByEmail(String email);


}
