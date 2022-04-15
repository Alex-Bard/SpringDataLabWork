package com.rs.lab5.repository;

import com.rs.lab5.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepos extends JpaRepository<StudentEntity, Integer> {
}
