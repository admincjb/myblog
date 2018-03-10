package com.jebill.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jebill.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
