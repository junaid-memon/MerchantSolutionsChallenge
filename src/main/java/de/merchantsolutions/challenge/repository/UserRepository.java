package de.merchantsolutions.challenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.merchantsolutions.challenge.model.User;

/**
 * @author memon
 * 
 *         This interface is used to create a repository for the User data
 *         and allows the CRUD operation on the stored data
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
	
}
