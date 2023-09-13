package com.tv.mvc.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;



@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Email(message="EMAIL BAD")
    private String email;

    @Size(min=6, message="NAME BAD!! 6 characters")
    private String name;

    @Size(min=5, message="PASS BAD!! 5 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
  
    



@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
private List<Rating> ratings;

@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
private List<Show> shows;
    
    
    
    
    
    public User() {
    }





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}





	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}





	public List<Rating> getRatings() {
		return ratings;
	}





	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	} 
    

    
    
    


}