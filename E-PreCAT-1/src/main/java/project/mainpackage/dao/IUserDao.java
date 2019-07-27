package project.mainpackage.dao;

import java.util.List;

import project.mainpackage.pojos.User;

public interface IUserDao {
	
	User checkLogin(String Username, String Password);
	boolean addUser(User u);
	void deleteUser(Integer id);
	List<User> getAllUsers();
	List<User> getUsersByRole(Integer id1);

}
