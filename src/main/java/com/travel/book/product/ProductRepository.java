package com.travel.book.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is a Product DAO interface
 * 
 * Please see the {@link com.travel.book.product.ProductRepository}
 * 
 * @author Bala Nimse
 * 
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}