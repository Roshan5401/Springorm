package com.spring.orm.entities;

//this is lecture-44 half done complete this
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Table(name="student_details")
public class Student {
	
	@Id
	@Column
	private int studentId;
	private String studentName;
	private String studentCity;
	
}
