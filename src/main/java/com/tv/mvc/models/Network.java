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
import javax.validation.constraints.Size;

@Entity
@Table(name="networks")
public class Network {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;

	

	
	    private String name;

	    
	   

@OneToMany(mappedBy="network", fetch = FetchType.LAZY)
private List<Show> shows;
	    
	    public Network() {}

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

		public List<Show> getShows() {
			return shows;
		}

		public void setShows(List<Show> shows) {
			this.shows = shows;
		}


	    
	    
}
