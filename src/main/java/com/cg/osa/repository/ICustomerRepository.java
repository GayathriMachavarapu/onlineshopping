package com.cg.osa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.osa.dto.CustomerDTO;

@Repository//("icustomerrepository")
public interface ICustomerRepository extends JpaRepository<CustomerDTO, Integer>{

	//List<CustomerDto> viewAllCustomer(String location);
}