package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.spring.models.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional()
	public void addStudent(Student student) {
		this.hibernateTemplate.save(student);

	}

	@Override
	public Student getStudentById(int studentid) {
		return this.hibernateTemplate.get(Student.class, studentid);
	}

	@Transactional
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);
	}

	@Override
	public void deleteStudent(int id) {
		Student student = hibernateTemplate.get(Student.class, id);
		hibernateTemplate.delete(student);
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = hibernateTemplate.loadAll(Student.class);
		return list;
	}

}
