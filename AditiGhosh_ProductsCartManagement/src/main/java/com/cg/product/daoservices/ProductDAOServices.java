package com.cg.product.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.product.beans.Product;

public interface ProductDAOServices extends JpaRepository<Product,String>{

}
