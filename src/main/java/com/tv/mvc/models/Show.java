package com.tv.mvc.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="shows")
public class Show {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

   


    private String name;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private double avg_rating;
    
    @OneToMany(mappedBy="show", fetch = FetchType.LAZY)
    private List<Rating> ratings;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="network_id")
    private Network network;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    public Show() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvg_rating() {
		return avg_rating;
	}

	public void setAvg_rating(double avg_rating) {
		this.avg_rating = avg_rating;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}
    
    
}
