package com.cg.osa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.osa.dto.AddressDTO;
import com.cg.osa.exception.AddressException;
import com.cg.osa.service.IAddressServiceImpl;
@RestController
@RequestMapping("/onlineshoppingapplication")
public class AddressController {
	@Autowired
	IAddressServiceImpl aimpl;
	
	@PostMapping("/addaddress")
	public AddressDTO addAddress(@RequestBody AddressDTO add) throws AddressException
	{
		aimpl.addAddress(add);
		return add;
	}
	@PutMapping("/updateaddress")
	public AddressDTO updateAddress(@RequestBody AddressDTO add) throws AddressException
	{
		aimpl.updateAddress(add);
		return add;
	}
	@DeleteMapping("/deladdress/{id}")
	public AddressDTO removeAddress(@PathVariable("id") int id) throws AddressException
	{
		return  aimpl.removeAddress(id);
	}
	
	@GetMapping("/viewaddress/{id}")
	public AddressDTO viewAddress(@PathVariable("id") int id) throws AddressException
	{
		return aimpl.viewAddress(id);
	}
	@GetMapping("/viewalladdress")
	 public List<AddressDTO> viewAllAddress(){
		 List<AddressDTO> a=aimpl.viewAllAddress();
		 return a;
    }
}
