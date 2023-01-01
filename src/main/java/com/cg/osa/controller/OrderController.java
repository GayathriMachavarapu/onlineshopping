package com.cg.osa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.osa.dto.OrderDTO;
import com.cg.osa.exception.OrderException;
import com.cg.osa.service.IOrderServiceImpl;

@RestController
@RequestMapping("/onlineshoppingapplication")
public class OrderController {
	@Autowired
	IOrderServiceImpl orderService;
	@PostMapping("/addorder")
	public OrderDTO addOrder(@RequestBody OrderDTO order)
	{
		orderService.addOrder(order);
		return order;
	}
	@PutMapping("/updateorder")
	public OrderDTO updateOrder(@RequestBody OrderDTO order) throws OrderException
	{
		orderService.updateOrder(order);
		return order;
	}
	
	
	@DeleteMapping("/deleteorder/{id}")
	public OrderDTO removeOrder(@PathVariable("id") int id)throws OrderException
	{
		
		return orderService.removeOrder(id);
	}
	@GetMapping("/getallorder")
	public List<OrderDTO> viewAllOrders()
	{
		List<OrderDTO> od=orderService.viewAllOrders();
		return od;
		
	}
	@GetMapping("/getorderby/{id}")
	public OrderDTO viewOrderById(@PathVariable ("id") int id)throws OrderException
	{
		
		return orderService.viewOrderById(id);
	}
	 @GetMapping("/getorderbycity/{city}")
	 public List<OrderDTO> viewAllCustomerByCity(@PathVariable("city") String city)throws OrderException{
		 List<OrderDTO> cd=orderService.viewAllOrdersByLocation(city);
		 return cd;
     }
	 @GetMapping("/getorderbycustomerid/{customerid}")
	 public List<OrderDTO> viewAllOrdersByCustomerId(@PathVariable("customerid") int customerId)throws OrderException{
		 List<OrderDTO> cd=orderService.viewAllOrdersByCustomerId(customerId);
		 return cd;
     }
	
	

}
