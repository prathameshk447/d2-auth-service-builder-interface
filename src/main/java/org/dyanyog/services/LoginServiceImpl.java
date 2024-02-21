package org.dyanyog.services;

import java.util.List;

import org.dyanyog.dto.LoginRequest;
import org.dyanyog.dto.LoginResponse;
import org.dyanyog.dto.User;
import org.dyanyog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class LoginServiceImpl {
	@Autowired
	UserRepository userRepo;

	
	public LoginResponse validate (@RequestBody LoginRequest loginRequest)
	{
		LoginResponse response = new LoginResponse();
		List<User> liUser= userRepo.findByUsernameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
			
		
		if(liUser.size()==1) {
			
			
				response.setStatus("success");
				response.setMessage("Login successful");
				
			}else {

				response.setStatus("fail");
				response.setMessage("Login failure");
			      }
				

	

        return response;
	}
}
