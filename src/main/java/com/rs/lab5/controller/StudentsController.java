package com.rs.lab5.controller;


import com.rs.lab5.model.StudentEntity;
import com.rs.lab5.servise.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("students")
public class StudentsController {

    private final StudentService service;

    @Autowired
    public StudentsController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showAll(Model model){
        List<StudentEntity> st = service.findAll();
        model.addAttribute("students",st);
        return "students/students-list";
    }
    @GetMapping("/{id}")
    public String showOne(@PathVariable("id") int id, Model model){
        StudentEntity st = service.findById(id);
        model.addAttribute("students",st);
        return "students/student";
    }
    @GetMapping("/create")
    public String createUserForm(StudentEntity st, Model model){
        model.addAttribute("students",new StudentEntity());
        return "students/create_student";
    }
    @PostMapping("/create")
    public String addExc(@Valid @ModelAttribute("students") StudentEntity st, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "students/create_student";
        }
        service.saveExc(st);
        return "redirect:/students/";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        StudentEntity st = service.findById(id);
        model.addAttribute("students",st);
        return "students/edit_student";
    }
    @PostMapping("/edit")
    public String editExc(@Valid @ModelAttribute("students") StudentEntity st, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("students",st);
            return "students/edit_student";
        }
        service.saveExc(st);
        return "redirect:/students/";
    }

    @GetMapping("/delete/{id}")
    public String deleteExc(@PathVariable("id") int id){
        service.deleteExc(id);
        return "redirect:/students/";
    }
}
