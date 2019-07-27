package project.mainpackage.sample;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.mainpackage.dao.IUserDao;
import project.mainpackage.pojos.User;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 4800,allowCredentials = "false",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
	
	@Autowired 
	private IUserDao userdao;
	
	//@GetMapping("/employees ")
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json")
	public User checkLogin(@RequestBody User u){
		System.out.println("--------------------------------");
		System.out.println(u);
		System.out.println("--------------------------------");
		User x = userdao.checkLogin(u.getUsername(),u.getPassword());
		System.out.println("--------------------------------");
		System.out.println(x);
		System.out.println("--------------------------------");
		 return x;
	}
	
	@RequestMapping(value="/login1",method=RequestMethod.POST,produces="application/json")
	public User checkLogin1(@RequestParam String  username, @RequestParam String  pass){
		System.out.println("--------------------------------");
		//System.out.println(u);
		System.out.println("--------------------------------");
		//User x = userdao.checkLogin(u.getUsername(),u.getPassword());
		User x = userdao.checkLogin(username,pass);
		System.out.println("--------------------------------");
		System.out.println(x);
		System.out.println("--------------------------------");
		 return x;
		
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST,consumes="application/json")
	public boolean addUser(@RequestBody User u) {
		if (userdao.addUser(u)) {
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public void deleteProducts(@PathVariable("id") String pd) {
		userdao.deleteUser(Integer.parseInt(pd));
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET,produces="application/json")
	public List<User> listAllUsers(){
		return userdao.getAllUsers();     
		
	}
	
	@RequestMapping(value="/findrole/{id}",method=RequestMethod.GET,produces="application/json")
	public  List<User> findByUser(@PathVariable("id") String pd) {
		return userdao.getUsersByRole(Integer.parseInt(pd));
	}
}
