package com.tv.mvc.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.tv.mvc.models.Network;
import com.tv.mvc.models.*;
import com.tv.mvc.repositories.NetworkRepository;
import com.tv.mvc.repositories.RatingRepository;
import com.tv.mvc.repositories.ShowRepository;
import com.tv.mvc.repositories.UserRepository;

@Service
public class TvServices {

	private final UserRepository userRepository;
	private final NetworkRepository networkRepository;
	private final ShowRepository showRepository;
	private final RatingRepository ratingRepository;
	
	public TvServices(UserRepository userRepository, NetworkRepository networkRepository, ShowRepository showRepository, RatingRepository ratingRepository) {
		
		this.networkRepository = networkRepository;
		this.showRepository = showRepository;
		this.ratingRepository = ratingRepository;
		this.userRepository = userRepository;}
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------
	
	 




	    public List<User> mostrarTodosLosUser(){
	    	return userRepository.findAll();
	    }



	public User buscarUser(Long id) {
		Optional<User> Optional = userRepository.findById(id);
		User user = Optional.get();
		return user;
	}

	public void borrarUser(User user) {
		userRepository.delete(user);
		
	}

	
	
	
	
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
	
	
    public boolean authentic(String email, String password) {
    	
        User user = userRepository.findByEmail(email);
    
        if(user == null) {
            return false;
        } else {

            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    
 
    public User regis(User user) {
    	String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }


	
	//---------------------------------------------------------------------------------------------------------------------------------------------

	
	
	
	
	
	

public List<Network> mostrarTodosLosNetwork(){
	return networkRepository.findAll();
}

public Network crearNetwork(Network network) {
	return networkRepository.save(network);
}


public Network buscarNetwork(Long id) {
	Optional<Network> Optional = networkRepository.findById(id);
	Network network = Optional.get();
	return network;
}

public void borrarNetwork(Network network) {
	networkRepository.delete(network);
	
}




public Network findByNet(String name) {
    return networkRepository.findByName(name);
}





public List<Show> mostrarTodosLosShow(){
	return showRepository.findAll();
}

public Show crearShow(Show  show) {
	return showRepository.save(show);
}


public Show buscarShow(Long id) {
	Optional<Show> Optional = showRepository.findById(id);
	Show show = Optional.get();
	return show;
}

public void borrarShow(Show  show) {
	showRepository.delete(show);
	
}


public Show findByShow(String name) {
    return showRepository.findByName(name);
}


//----------------------------------------------------------------------------------------------------------------------------------------------








public List<Rating> mostrarTodosLosRating(){
	return ratingRepository.findAll();
}

public Rating crearRating(Rating  rating) {
	return ratingRepository.save(rating);
}


public Rating buscarRating(Long id) {
	Optional<Rating> Optional = ratingRepository.findById(id);
	Rating rating = Optional.get();
	return rating;
}

public void borrarRating(Rating rating) {
	ratingRepository.delete(rating);
	
}


	
//-----------------------------------------------------------------------------------------------------------------------------	
}
