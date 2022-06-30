package de.merchantsolutions.challenge.repository;
/**
 * @author memon
 * 
 *         This interface is used to create a repository for the District data
 *         and allows the CRUD operation on the stored data
 */

import org.springframework.data.repository.CrudRepository;

import de.merchantsolutions.challenge.model.Buyer;

public interface BuyerRepository extends CrudRepository<Buyer, Long> {
}
