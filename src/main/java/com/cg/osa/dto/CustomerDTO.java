package com.cg.osa.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_table")
public class CustomerDTO {
	@Id
	//@GeneratedValue (strategy = GenerationType.AUTO)
	int customerId;
	@Column(name="firstname")
	String firstName;
	@Column(name="lastname")
	String lastName;
	@Column(name="mobileno")
	String mobileNo;
	@OneToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	AddressDTO address;
	@Column(name="email")
	String email;
	public CustomerDTO() {
		super();
	}
	public CustomerDTO(int customerId, String firstName, String lastName, String mobileNo, AddressDTO address,
			String email) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo= mobileNo;
		this.address = address;
		this.email = email;
	}
	
	public int getCustomerId() {
		return customerId;
	}
//	public CustomerDto(String customerId, String firstName, String lastName, String mobileNo, String email) {
//	super();
//	this.customerId = customerId;
//	this.firstName = firstName;
//	this.lastName = lastName;
//	this.mobileNo = mobileNo;
//	this.email = email;
//}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", MobileNo=" + mobileNo + ", email=" + email + "]";
	}
}
