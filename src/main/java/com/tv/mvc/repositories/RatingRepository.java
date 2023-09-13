package com.tv.mvc.repositories;

import com.tv.mvc.models.*;
import java.util.List;
import java.util.Optional;
import com.tv.mvc.models.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
	 List<Rating> findAll();


}

