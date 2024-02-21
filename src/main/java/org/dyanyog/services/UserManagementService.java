package org.dyanyog.services;

import org.dyanyog.dto.User;
import org.dyanyog.dto.UserRequest;
import org.dyanyog.dto.UserResponse;

public interface UserManagementService {
	public UserResponse addUser(UserRequest userRequest);

	public User getSingleUser(long userId);

	public String deleteuser(Long userId);

	public UserResponse UpdateUser(Long userId, UserRequest request);

}
