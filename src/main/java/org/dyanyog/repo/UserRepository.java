package org.dyanyog.repo;


import java.util.List;

import org.dyanyog.dto.User;
import org.dyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends JpaRepository<Users, Long> {
	List<User>findByUsernameAndPassword(String Username, String Password);
	
	
	
	
	

	
	Users save(Users u);

	
}
