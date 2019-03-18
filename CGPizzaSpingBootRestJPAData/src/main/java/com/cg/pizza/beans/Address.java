package com.cg.pizza.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
 private String pincode;
 private String street;
 Address(){}
public Address(String pincode, String street) {
	super();
	this.pincode = pincode;
	this.street = street;
}
@Override
public String toString() {
	return "Address [pincode=" + pincode + ", street=" + street + "]";
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
 
}
