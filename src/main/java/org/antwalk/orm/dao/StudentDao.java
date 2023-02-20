package org.antwalk.orm.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.antwalk.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		//insert
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i;
	}
	
	// get single data object
	
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	//get all students 

	public List<Student> getAllSudents(){
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class,studentId);
		this.hibernateTemplate.delete(student);
		System.out.println("Deleted");
	}
	
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
