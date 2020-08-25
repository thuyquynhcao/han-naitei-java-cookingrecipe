package com.cookingrecipe.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.NumberFormat;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Recipes")
@Getter
@Setter
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank
	@Column(nullable = false)
	private String name;

	@NumberFormat
	private Integer time;

	private String image;

	@NumberFormat
	private Integer likes;

	@NotNull
	@OneToMany(mappedBy = "recipe")
	private List<Step> steps;
	
	@NotBlank
	@Column(columnDefinition="TEXT")
	private String ingredient;

	@NotNull
	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "recipe")
	private List<Comment> comments;

	@ManyToMany
	private List<Category> categories;
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;

}
