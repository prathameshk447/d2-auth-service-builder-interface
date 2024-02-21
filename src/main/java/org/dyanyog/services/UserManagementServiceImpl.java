package org.dyanyog.services;

import java.util.List;
import java.util.Optional;

import org.dyanyog.dto.LoginRequest;
import org.dyanyog.dto.LoginResponse;
import org.dyanyog.dto.User;
import org.dyanyog.dto.UserRequest;
import org.dyanyog.dto.UserResponse;
import org.dyanyog.entity.Users;
import org.dyanyog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserManagementServiceImpl {

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserResponse response;

	@Autowired
	User userResponse;

	public UserResponse addUser(UserRequest userRequest) {

		Users u = Users.getInstance().setUsername(userRequest.getUsername()).setPassword(userRequest.getPassword())
				.setEmail(userRequest.getEmail()).setAge(userRequest.getAge());

		u = userRepo.save(u);

		response.setStatus("Success");
		response.setMessage("user added successfully");
		response.setUser_id(u.getUser_id());

		return response;
	}

	public User getSingleUser(long userId) {

		User userResponse = new User();

		java.util.Optional<Users> receiveData = userRepo.findById(userId);

		if (receiveData.isEmpty()) {
			userResponse.setStatus("Fail");
			userResponse.setMessage("User not found");
		} else {
			Users user = (Users) receiveData.get();

			userResponse.setStatus("success");
			userResponse.setMessage("user found");

			userResponse.setUsername(user.getUsername());
			userResponse.setPassword(user.getPassword());
			userResponse.setEmail(user.getEmail());
			userResponse.setAge(user.getAge());

			userResponse.setUser_id(user.getUser_id());

		}
		return userResponse;

	}

	public String deleteuser(Long userId) {
		userRepo.deleteById(userId);
		return "The User Id" + userId + "has been deleted";
	}

	public UserResponse UpdateUser(Long userId, UserRequest request) {

		Optional<Users> receivedData = userRepo.findById(userId);
		if (receivedData.isPresent()) {

			Users usersTable = Users.getInstance().setAge(request.getAge()).setEmail(request.getEmail())
					.setPassword(request.getPassword()).setUsername(request.getUsername()).setUser_id(userId);

			usersTable = userRepo.save(usersTable);

			response.setMessage("User updated Successfully");
			response.setStatus("Success");
			response.setUser_id(userId);
			response.setUsername(usersTable.getUsername());
			response.setPassword(usersTable.getPassword());
			response.setEmail(usersTable.getEmail());
			response.setAge(usersTable.getAge());

		}
		return response;
	}
}
