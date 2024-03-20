package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class UserService {

    private List<User> users = new ArrayList<User>();

    public UserService()
    {
    	System.out.println("from user service constructor");
    	users.add(new User(0,"John"));
    	users.add(new User(1,"Alice"));
 
    	
    }
    public User getUser(int id) {
			// write your code here
    	User user = users.get(id);
	      return user; // User not found
    }

    public List<User> getAllUsers() {
			// write your code here
        return users;
    }

    public User createUser(User user) {
        // write your code here
    	users.add(user);
        return user;
    }

    public User updateUser(int id, User user) {
       // write your code here
    	Iterator <User> uIter = users.iterator();
    	int ctr = -1;
    	User userU = new User();
    	while(uIter.hasNext())
    	{
    		
    		userU = uIter.next();
    		ctr++;
    		if(userU.getId() == id)
    		{
    			users.remove(ctr);
    			users.add(ctr, user);
    			break;
    		}
    	}
		return user; // User not found
    }

    public boolean deleteUser(int id) {
       // write your code here
    	Iterator <User> uIter = users.iterator();
    	int ctr = -1;
    	User userU = new User();
    	while(uIter.hasNext())
    	{
    		
    		userU = uIter.next();
    		ctr++;
    		if(userU.getId() == id)
    		{
    			users.remove(ctr);
    			return true;
    			
    		}
    	}
    	return false;
    }
    /*public String toString()
    {
    	return "hello world";
    }*/
    
    public String getGreetings()
    {
    	return "hello world";
    }
}
