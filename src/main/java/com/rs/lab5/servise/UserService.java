package com.rs.lab5.servise;

import com.rs.lab5.model.UserExceptionEntity;
import com.rs.lab5.repository.UserExceptionRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserExceptionRepos userExceptionRepository;

    @Autowired
    public UserService(UserExceptionRepos userExceptionRepository) {
        this.userExceptionRepository = userExceptionRepository;
    }

    public List<UserExceptionEntity> findAll(){
        return userExceptionRepository.findAll();
    }
    public UserExceptionEntity findById(int id){
        return userExceptionRepository.getById(id);
    }
    public UserExceptionEntity saveExc(UserExceptionEntity exception){
        return userExceptionRepository.save(exception);
    }
    public void deleteExc(int id){
         userExceptionRepository.deleteById(id);
    }




}
