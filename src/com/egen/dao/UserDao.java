package com.egen.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.egen.entity.Movie;
import com.egen.entity.User;


@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<User> findAll()
	{
		TypedQuery<User> query1 = entityManager.createQuery("SELECT u FROM User u", User.class); // User is case sensitive
		List<User> userslist = query1.getResultList();
		 return userslist;
	}
	
	public User  findOne(String Title )  
	{
		return entityManager.find(User.class, Title);
	}
	
	public User createUser(User user) 
	{
		
		entityManager.persist(user);
		return user;
		
	}
	
	public User update(User user) 
	{
		
		return entityManager.merge(user);
	}
	public User delete(String Title ) 
	{
		User user =  entityManager.find(User.class, Title);
		entityManager.remove(Title);
		return user;
	}
	
	public List<String> addMoviestoWishList(User user,String title ){
	
		user.setMovie(title);
		
    return user.getMovie();
	}
	
}
