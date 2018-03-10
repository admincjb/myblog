package com.jebill.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jebill.dao.StudentDao;
import com.jebill.entity.Student;

@Service(value="studentService")
public class StudentServiceImpl implements StudentService {
	
	@Resource
	private StudentDao studentDao;

	@Override
	public void addStu(Student student) {
		studentDao.save(student);
	}

}
