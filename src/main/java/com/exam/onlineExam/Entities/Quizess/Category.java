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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	@Column(length = 1000)
	private String description;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="category")
	@JsonIgnore
	Set<Quiz> quizes=new LinkedHashSet<>();
	
	
	
	
	public Category() {
		super();
	}
	public Category(String title, String description, Set<Quiz> quizes) {
		super();
		this.title = title;
		this.description = description;
		this.quizes = quizes;
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
	public Set<Quiz> getQuizes() {
		return quizes;
	}
	public void setQuizes(Set<Quiz> quizes) {
		this.quizes = quizes;
	}
	
	
	
}
