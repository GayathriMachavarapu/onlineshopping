package com.cg.osa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.osa.dto.UserDTO;
import com.cg.osa.exception.UserException;
import com.cg.osa.service.IUserServiceImpl;
@RestController
@RequestMapping("/onlineshoppingapplication")
public class UserController {
	@Autowired
	private IUserServiceImpl impl;
	@PostMapping("/adduser")
	public UserDTO addUser(@RequestBody UserDTO user) throws UserException
	{
		return impl.addUser(user);
	}
	@DeleteMapping("/deluser/{id}")
	public UserDTO removeUser(@PathVariable("id") int id) throws UserException
	{
		return impl.removeUser(id);
	}
	@GetMapping("/viewuser/{id}")
	public UserDTO viewUser(@PathVariable("id")int id) throws UserException
	{
		return impl.viewUser(id);
	}
	@GetMapping("/signoutuser")
	public boolean signOut(UserDTO user)
	{
		return impl.signOut(user);
	}
	@GetMapping("/login/{id}/{pwd}")
	public List<UserDTO> validateUser(@PathVariable("id") int id,@PathVariable("pwd") String password) throws UserException
	{
		return impl.validateUser(id, password);
	}

}
