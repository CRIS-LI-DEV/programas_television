package com.tv.mvc.repositories;

import java.util.List;
import java.util.Optional;
import com.tv.mvc.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {
	 Optional<Show> findByid(int id);
	 List<Show> findAll();
	  Show findByName(String name);
}

