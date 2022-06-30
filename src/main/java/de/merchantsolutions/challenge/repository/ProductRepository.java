package de.merchantsolutions.challenge.repository;

import org.springframework.data.repository.CrudRepository;

import de.merchantsolutions.challenge.model.Product;

/**
 * @author memon
 * 
 *         This interface is used to create a repository for the District data
 *         and allows the CRUD operation on the stored data
 */

public interface ProductRepository extends CrudRepository<Product, Long> {

}