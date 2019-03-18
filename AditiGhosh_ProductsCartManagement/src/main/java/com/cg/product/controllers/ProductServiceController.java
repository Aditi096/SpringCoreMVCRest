package com.cg.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.cg.product.beans.Product;
import com.cg.product.exceptions.ProductNotFoundException;
import com.cg.product.services.ProductCartManagementServices;

@Controller
public class ProductServiceController {
	@Autowired
	ProductCartManagementServices productServices;

	@RequestMapping(value= {"/addProduct"},method=RequestMethod.POST,
			consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> addProductDetails(@ModelAttribute Product product){
		product=productServices.addProduct(product);
		return new ResponseEntity<>("Product added successfully Product Id :-"+product.getId(),HttpStatus.OK);
	}
	@RequestMapping(value= {"/updateProduct"},method=RequestMethod.PUT,
			consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> updateProductDetails(@ModelAttribute Product product) throws ProductNotFoundException{
		product=productServices.updateProduct(product);
		return new ResponseEntity<>("Product updated successfully Product Id :-"+product.getId(),HttpStatus.OK);

	}
	@RequestMapping(value="/removeProduct/{productId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> removeProductbyPath(@PathVariable(value="productId")String productId) throws ProductNotFoundException{
		productServices.removeProduct(productId);
		return new ResponseEntity<>("Product details successfully removed ",HttpStatus.OK);
	}
	@RequestMapping(value= {"/viewProducts"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Product>>viewAllProducts() throws ProductNotFoundException{
		List<Product> products=productServices.viewProducts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	@RequestMapping(value= {"/findProduct"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Product> findProductDetails(@RequestParam String id) throws ProductNotFoundException{
		Product product=productServices.findProductById(id);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
}
