package bing.server;

import javax.jws.WebService;

@WebService
public interface IUserService {

	public String userLogin(String username, String userpwd);
	
	public String findUserById(String userid);
}

