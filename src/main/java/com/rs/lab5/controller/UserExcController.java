package com.rs.lab5.controller;

import com.rs.lab5.model.UserExceptionEntity;
import com.rs.lab5.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("exceptions")
public class UserExcController {

    private final UserService service;

    @Autowired
    public UserExcController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showAll(Model model){
        List<UserExceptionEntity> exc = service.findAll();
        model.addAttribute("exceptions",exc);
        return "user-exceptions-list";
    }
    @GetMapping("/{id}")
    public String showOne(@PathVariable("id") int id, Model model){
        UserExceptionEntity exc = service.findById(id);
        model.addAttribute("exception",exc);
        return "user_exc";
    }
    @GetMapping("/create")
    public String createUserForm(UserExceptionEntity userExc, Model model){
        model.addAttribute("userExc",new UserExceptionEntity());
        return "create_user_exc";
    }
    @PostMapping("/create")
    public String addExc(@Valid @ModelAttribute("userExc") UserExceptionEntity userExc, BindingResult result, Model model){
        if (result.hasErrors()) {
           // model.addAttribute("userExc",userExc);
            return "create_user_exc";
        }
        service.saveExc(userExc);
        return "redirect:/exceptions/";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        UserExceptionEntity exc = service.findById(id);
        model.addAttribute("userExc",exc);
        return "edit_user_exc";
    }
    @PostMapping("/edit")
    public String editExc(@Valid @ModelAttribute("userExc") UserExceptionEntity userExc, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("userExc",userExc);
            return "edit_user_exc";
        }
        service.saveExc(userExc);
        return "redirect:/exceptions/";
    }

    @GetMapping("/delete/{id}")
    public String deleteExc(@PathVariable("id") int id){
        service.deleteExc(id);
        return "redirect:/exceptions/";
    }
}
