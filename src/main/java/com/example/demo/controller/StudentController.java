package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("list.do")
    public String list(Model model){
        List<Student> students=studentService.list();
        model.addAttribute("students",students);
        return "listStudents";
    }
    @RequestMapping("delete.do")
    public String delete(int id,Model model){
        studentService.removeStudent(id);
        return list(model);
    }

}
