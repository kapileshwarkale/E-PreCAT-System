package project.mainpackage.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.mainpackage.pojos.Role;
import project.mainpackage.pojos.User;
import project.mainpackage.repositories.UserRepository;

@Service
@Transactional
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private UserRepository urepo;

	@Override
	public User checkLogin(String Username, String Password) {
		//return urepo.findByEmailAndPassword(String user, String pass)
		User temp = urepo.findByUsernameAndPassword(Username, Password);
		return (new User(temp.getUID(),temp.getUsername(),temp.getRole()));
		//return null;
	}

	@Override
	public boolean addUser(User u) {
		User x = urepo.save(u);
		if (x == null) {
			return false;
		}
		return true;
	}

	@Override
	public void deleteUser(Integer id) {
		urepo.deleteById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return urepo.findAll();
	}

	@Override
	public List<User> getUsersByRole(Integer id1) {
		//return urepo.findByRole_ROLEID(id);
		/*List <User> rr = urepo.findAll();
		//Stream<User> xx = rr.stream().filter(p ->p.getRole().getRoleId()== id1);
		List<User> xx = rr.stream().filter(p ->p.getRole().getRoleId()== id1).collect(Collectors.toCollection(() -> new ArrayList<User>()));*/
		List <User> rr = urepo.findByRole_ROLEID(id1);
		/*System.out.println(xx);
		return xx;*/
		System.out.println(rr);
		return rr;
		
	}


}
