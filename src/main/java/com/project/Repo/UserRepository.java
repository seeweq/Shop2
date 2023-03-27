package com.project.Repo;

import com.project.User.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByEmail(String email);
}
