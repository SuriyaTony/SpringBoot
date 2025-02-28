package com.example.studentcrud.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "studentname", nullable = false)
	private String studentname;
	
	@Column(name= "course", nullable = false)
	private String course;
	
	@Column(name= "fee", nullable = false)
	private int fee;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Student(Long id, String studentname, String course, int fee) {
		super();
		this.id = id;
		this.studentname = studentname;
		this.course = course;
		this.fee = fee;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getStudentname() {
		return studentname;
	}



	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	public int getFee() {
		return fee;
	}



	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
	
	
	
}
