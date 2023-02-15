package com.exam.onlineExam.Entities.Quizess;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	@Column(length = 500)
	private String description;
	private boolean active=false;
	private double maxMark;
	private long noOfQuestion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="quiz")
	@JsonIgnore
	private Set<Question> questions=new LinkedHashSet<>();

	public Quiz(String title, String description, double maxMark, long noOfQuestion, Category catagory) {
		super();
		this.title = title;
		this.description = description;
		this.maxMark = maxMark;
		this.noOfQuestion = noOfQuestion;
		this.category = catagory;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Quiz() {
		super();
	}

	public long getId() {
		return id;
	}






	public void setId(long id) {
		this.id = id;
	}






	public String getTitle() {
		return title;
	}






	public void setTitle(String title) {
		this.title = title;
	}






	public String getDescription() {
		return description;
	}






	public void setDescription(String description) {
		this.description = description;
	}






	public double getMaxMark() {
		return maxMark;
	}






	public void setMaxMark(double maxMark) {
		this.maxMark = maxMark;
	}






	public long getNoOfQuestion() {
		return noOfQuestion;
	}






	public void setNoOfQuestion(long noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}






	public Category getCategory() {
		return category;
	}






	public void setCategory(Category category) {
		this.category = category;
	}






	public Set<Question> getQuestions() {
		return questions;
	}






	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}






	
	
	
}
