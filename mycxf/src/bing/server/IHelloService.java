package bing.server;

import javax.jws.WebService;

@WebService
public interface IHelloService {

    public String userLogin(String username,String userpwd);
    
    public String sayHello(String username);
    
    public String getInfo(String name);
    
}