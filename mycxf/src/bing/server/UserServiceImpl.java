package bing.server;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "bing.server.IUserService", serviceName = "UserService", targetNamespace="http://ws.devba.com")
public class UserServiceImpl implements IUserService {

	@Override
	public String userLogin(@WebParam(name = "username")String username, @WebParam(name = "userpwd")String userpwd) {
		String str = "登录失败！";
		if("admin".equals(username)&&"admin".equals(userpwd)){
			str = "登陆成功!";
		}
		// TODO Auto-generated method stub
		return str;

	}

	@Override
	public String findUserById(String userid) {

		// TODO Auto-generated method stub
		return userid;

	}

}

