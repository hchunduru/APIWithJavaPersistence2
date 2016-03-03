 package com.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egen.entity.User;
import com.egen.exceptionHandlers.BadRequestByUser;
import com.egen.exceptionHandlers.UserNotFoundException;
import com.egen.service.UserService;

@RestController
@RequestMapping("/users")
public class UserControl {

	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll()
	{
		return service.findAll();
	}
	@RequestMapping(value = "{Title}" ,method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public User  findOne(@PathVariable("Title") String Title ) throws UserNotFoundException 
	{
		return service.findOne(Title);
	}
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User create(@RequestBody User user) throws BadRequestByUser
	{
		return service.createUser(user);
	}
	@RequestMapping(value = "{Title}" , method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User update(@PathVariable("Title") String Title ,@RequestBody User user) throws UserNotFoundException
	{
		return service.update(Title, user);
	}
	@RequestMapping(value = "{Title}" , method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User delete(@PathVariable("Title") String Title ) throws UserNotFoundException
	{
		return service.delete(Title);
		
	}
	@RequestMapping(value = "{Title}" , method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User wishlist(@PathVariable("Title") String Title ,@RequestBody User user) throws UserNotFoundException
	{
		return service.wishList(user, Title);
	}
	
	}
