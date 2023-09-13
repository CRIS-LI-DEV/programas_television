package com.tv.mvc.repositories;

import java.util.List;
import java.util.Optional;
import com.tv.mvc.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	 Optional<User> findByid(int id);
	 List<User> findAll();
	  User findByEmail(String email);
}

