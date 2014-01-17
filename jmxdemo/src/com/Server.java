package com;

import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import com.mbean.My;
import com.mbean.SimpleStandard;


public class Server {

	public static void main(String[] args) {
		
		MBeanServer mbServer=MBeanServerFactory.createMBeanServer();
		System.out.println("------MBean服务器创建成功--------");
		String defaultDomain=mbServer.getDefaultDomain();
		SimpleStandard simpleStandard=new SimpleStandard();
		My mybean = new My();
		ObjectName objectname=null;
		try {
			objectname=new ObjectName(defaultDomain+":name=simpletest");
			mbServer.registerMBean(simpleStandard, objectname);
			System.out.println("-------simpletest向MBean注册成功----");
			objectname=new ObjectName(defaultDomain+":name=mytest");
			mbServer.registerMBean(mybean, objectname);
			System.out.println("-------mytest向MBean注册成功--------");
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * 创建一个jmx连接服务器
		 */
		try {
			String ip = "127.0.0.1";
			int port = 40000;
			String user = "admin";
			String password = "admin";
			// 启动RMI注册服务，指定端口
			LocateRegistry.createRegistry(port);
			// 存取该JMX服务的URL
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi://" + ip + ":" + port + "/jndi/rmi://" + ip + ":" + port + "/server");
			System.out.println("url = service:jmx:rmi://127.0.0.1:40000/jndi/rmi://127.0.0.1:40000/server");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put(JMXConnector.CREDENTIALS, new String[] { user, password });

			JMXConnectorServer jmxConnectorServer = JMXConnectorServerFactory.newJMXConnectorServer(url, map, mbServer);
			System.out.println("--------JMX连接服务器创建成功--------");
			System.out.println("--------启动JMX服务----------");
			jmxConnectorServer.start();
			System.out.println("--------启动成功-------------");
			
		} catch (Exception e) {
			System.out.println("启动报错！");
			e.printStackTrace();
		} 
		
	}
}
