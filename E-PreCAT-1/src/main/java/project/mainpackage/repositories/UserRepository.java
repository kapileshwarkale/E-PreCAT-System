package project.mainpackage.repositories;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.mainpackage.pojos.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsernameAndPassword(String Username,String Password);
	User save(User u); 
	void deleteById(Integer id);
	List<User> findAll();
	
	//@EntityGraph(value = "Role.RoleID", type = EntityGraphType.FETCH)
	//@Query("FROM Role r INNER JOIN FETCH r.RoleID WHERE r.RoleID = :id")
	//List<User> findByRole(@Param("id") int id);
	List<User> findByRole_ROLEID(Integer id);
	
	//Stream<User> findAll();
}
