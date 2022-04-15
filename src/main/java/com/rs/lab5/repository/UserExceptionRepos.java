package com.rs.lab5.repository;

import com.rs.lab5.model.UserExceptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExceptionRepos extends JpaRepository<UserExceptionEntity,Integer> {

}
