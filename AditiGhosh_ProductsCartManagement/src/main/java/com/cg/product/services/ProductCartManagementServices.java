package com.cg.product.services;

import java.util.List;

import com.cg.product.beans.Product;
import com.cg.product.exceptions.ProductNotFoundException;

public interface ProductCartManagementServices {
	public Product addProduct(Product product);
	public Product updateProduct(Product product)throws ProductNotFoundException;
	boolean removeProduct(String id)throws ProductNotFoundException;
	public List<Product> viewProducts() throws ProductNotFoundException;
	public Product findProductById(String id)throws ProductNotFoundException;
	
}
