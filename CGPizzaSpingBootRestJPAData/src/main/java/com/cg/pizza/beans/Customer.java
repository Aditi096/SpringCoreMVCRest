package com.cg.pizza.beans;

import java.util.Map;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String customerId;
	private String name;
	@Embedded
	private Address address;
	
	private Map<Integer,Order> orders;
}
