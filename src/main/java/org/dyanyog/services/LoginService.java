package org.dyanyog.services;

import org.dyanyog.dto.LoginRequest;
import org.dyanyog.dto.LoginResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoginService {
	public LoginResponse validate (@RequestBody LoginRequest loginRequest);
}
