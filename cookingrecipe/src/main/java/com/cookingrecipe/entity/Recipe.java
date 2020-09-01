package com.cookingrecipe.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;

@Entity
@Table(name = "Recipes")
@Data
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String name;

	private Integer time;

	private String image;

	private Integer likes;

	@OneToMany(mappedBy = "recipe")
	private Set<Step> steps;

	@Column(columnDefinition="TEXT")
	private String ingredient;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "recipe")
	private Set<Comment> comments;

	@ManyToMany
	private Set<Category> categories;

	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;

}
