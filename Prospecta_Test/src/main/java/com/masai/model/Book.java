package com.masai.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
private Integer bookId;
	
@NotNull
private	String title;
	
@NotNull
private	String description;
	
@NotNull
private	String auth;

@NotNull
private	boolean https;

@NotNull
private	String cors;

@NotNull
private	String category;
}
