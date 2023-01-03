package com.cg.osa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.osa.dto.CustomerDTO;

import com.cg.osa.exception.CustomerException;
import com.cg.osa.repository.ICustomerRepository;
@Service//("customerService")
public class ICustomerServiceImpl implements ICustomerService{
	// @Qualifier("productRepository")
	 @Autowired
	    private ICustomerRepository customerRepository;
	 
	    
	    public CustomerDTO addCustomer(CustomerDTO cust) throws CustomerException{
	    	if(customerRepository.existsById(cust.getCustomerId())) {
	    		 throw new CustomerException("Id already exist");
	    	}
	    	else {
	    	customerRepository.save(cust);
	    	}
	    	return cust;
	    }
	    public CustomerDTO updateCustomer(CustomerDTO cust)throws CustomerException {
	    	if(customerRepository.existsById(cust.getCustomerId())) {
	    		customerRepository.save(cust);
		    	return cust;
	    		
	    	}
	    	else {
	    		 throw new CustomerException("Id not found");
	    		
	    	}
	    }
    public CustomerDTO removeCustomer(int id) throws CustomerException{
 	   if(customerRepository.existsById(id)) {
 		   CustomerDTO cust=customerRepository.findById(id).get();
 	   if(customerRepository.existsById(id)) {
 	    customerRepository.deleteById(id);
 	   }
 	    return cust;
 	   }else {
 		   throw new CustomerException("Id not found");
 	   }
 	   
    }
    public List<CustomerDTO> viewAllCustomer(){
 	   return customerRepository.findAll();
    }

   public CustomerDTO viewCustomer(int id) throws CustomerException{
 	  if(customerRepository.existsById(id)) {
 	  return customerRepository.findById(id).get();
 	  }
 	  else {
 		  throw new CustomerException("Id not found");
 	  }
   }
  
   
   public List<CustomerDTO> viewAllCustomerByCity(String city) throws CustomerException{
	  List<CustomerDTO> list= customerRepository.findAll();
	  List<CustomerDTO> custCity = new ArrayList<CustomerDTO>();
	  for(int i=0;i<list.size();i++) {
		  CustomerDTO cust=list.get(i);
		  if(city.equals(cust.getAddress().getCity())) {
			 custCity.add(cust); 
		  }
		  
	  }
	  if(custCity.size()!=0) {
	   return custCity;
   }else {
		  throw new CustomerException("no customer from the city "+city);
   }
   }
	       

}
