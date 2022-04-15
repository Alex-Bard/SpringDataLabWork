package com.rs.lab5.servise;

import com.rs.lab5.model.StudentEntity;
import com.rs.lab5.model.UserExceptionEntity;
import com.rs.lab5.repository.StudentRepos;
import com.rs.lab5.repository.UserExceptionRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepos repos;
    @Autowired
    public StudentService(StudentRepos repos) {
        this.repos = repos;
    }

    public List<StudentEntity> findAll(){
        return repos.findAll();
    }
    public StudentEntity findById(int id){
        return repos.getById(id);
    }
    public StudentEntity saveExc(StudentEntity exception){
        return repos.save(exception);
    }
    public void deleteExc(int id){
        repos.deleteById(id);
    }
}
