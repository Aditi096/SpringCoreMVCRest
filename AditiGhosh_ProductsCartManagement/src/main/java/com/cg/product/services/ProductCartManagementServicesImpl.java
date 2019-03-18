package com.cg.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.cg.product.beans.Product;
import com.cg.product.daoservices.ProductDAOServices;
import com.cg.product.exceptions.ProductNotFoundException;

@Component("productServices")
public class ProductCartManagementServicesImpl implements ProductCartManagementServices {
	@Autowired
	private ProductDAOServices productDAOServices;
	//to add a product to the table Product in database
	@Override
	public Product addProduct(Product product) {
		return productDAOServices.save(product);
	}
	//to update an existing product in the table Product in database
	@Override
	public Product updateProduct(Product product) throws ProductNotFoundException {
		productDAOServices.save(product);
		return product;
	}
	//to remove a product from the table Product in database using id
	@Override
	public boolean removeProduct(String productId)throws ProductNotFoundException {
		productDAOServices.delete(findProductById(productId));
		return true;
	}
	//to get all products from the table Product in database
	@Override
	public List<Product> viewProducts() throws ProductNotFoundException {
		return productDAOServices.findAll();
	}
	//to get one product from the table Product in database using id
	@Override
	public Product findProductById(String id) throws ProductNotFoundException {
		return productDAOServices.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found for Product Id : "+id));
	}

}
