package bing.server;

import javax.jws.WebService;

/**
 * <p>
 * WebService实现类
 * </p>
 */
@WebService(endpointInterface = "bing.server.IHelloService", serviceName = "HelloService")
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String username) {
        return "hello, " + username;
    }

	@Override
	public String userLogin(String username, String userpwd) {
		
		// TODO Auto-generated method stub
		return "登录成功！";
		
	}

	@Override
	public String getInfo(String name) {
		System.out.println(name);
		// TODO Auto-generated method stub
		return "返回："+name;
		
	}

}