package com.tv.mvc.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity

@Table(name="ratings")
public class Rating {@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@Min(1)
	@Max(5)
	private double rating_pts;

    private String name;
     
  
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="user_id")

private User user;




@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="show_id")

private Show show;


public Rating(){}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public double getRating_pts() {
	return rating_pts;
}


public void setRating_pts(double rating_pts) {
	this.rating_pts = rating_pts;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}


public Show getShow() {
	return show;
}


public void setShow(Show show) {
	this.show = show;
}



}
