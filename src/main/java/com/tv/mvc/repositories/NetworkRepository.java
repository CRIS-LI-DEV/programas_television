package com.tv.mvc.repositories;

import java.util.List;
import java.util.Optional;
import com.tv.mvc.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface NetworkRepository extends CrudRepository<Network, Long> {
	 Optional<Network> findByid(int id);
	
	 List<Network> findAll();
	 
	 Network findByName(String name);
}

