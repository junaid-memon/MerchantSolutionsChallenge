package de.merchantsolutions.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import de.merchantsolutions.challenge.model.User;

/**
 * @author memon
 * 
 *         This interface is used to create a repository for the District data
 *         and allows the CRUD operation on the stored data
 */

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

	//User findbyUsername(String username);
	
}
