package com.jebill.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jebill.entity.Student;
import com.jebill.service.StudentService;

@RestController
@RequestMapping(value="/student")
public class StudentController {
	
	@Resource
	private StudentService studentService;
	
	@ResponseBody
	@PostMapping(value="/addinfo")
	public String addinfo(@Valid Student student, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return bindingResult.getFieldError().getDefaultMessage();
		}else {
			studentService.addStu(student);
			return "添加学生信息成功！";
		}
	}

}
