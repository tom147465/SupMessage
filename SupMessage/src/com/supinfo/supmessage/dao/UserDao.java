package com.supinfo.supmessage.dao;

import java.util.List;

import com.supinfo.supmessage.entity.Contact;
import com.supinfo.supmessage.entity.User;



public interface UserDao {
    public User addUser(User user);

	public User finUser(String username);

	public User UpdateUser(User user);

	public Long Countuser();

    
    //public Category retrieveCategoryById(Long id);	

    //public List<Category> retrieveAllCategories();
    
    //public void updateCategory(Category category);

}
