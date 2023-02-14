package com.spring.dao;

import java.util.List;

import com.spring.models.Student;

public interface StudentDao {
	
	public void addStudent(Student student);
	public Student getStudentById(int id);
	public void updateStudent(Student student);
	public void deleteStudent(int id);
	public List<Student> getAllStudents();

}
