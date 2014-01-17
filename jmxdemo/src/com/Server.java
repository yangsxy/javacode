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
		System.out.println("------MBean�����������ɹ�--------");
		String defaultDomain=mbServer.getDefaultDomain();
		SimpleStandard simpleStandard=new SimpleStandard();
		My mybean = new My();
		ObjectName objectname=null;
		try {
			objectname=new ObjectName(defaultDomain+":name=simpletest");
			mbServer.registerMBean(simpleStandard, objectname);
			System.out.println("-------simpletest��MBeanע��ɹ�----");
			objectname=new ObjectName(defaultDomain+":name=mytest");
			mbServer.registerMBean(mybean, objectname);
			System.out.println("-------mytest��MBeanע��ɹ�--------");
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * ����һ��jmx���ӷ�����
		 */
		try {
			String ip = "127.0.0.1";
			int port = 40000;
			String user = "admin";
			String password = "admin";
			// ����RMIע�����ָ���˿�
			LocateRegistry.createRegistry(port);
			// ��ȡ��JMX�����URL
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi://" + ip + ":" + port + "/jndi/rmi://" + ip + ":" + port + "/server");
			System.out.println("url = service:jmx:rmi://127.0.0.1:40000/jndi/rmi://127.0.0.1:40000/server");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put(JMXConnector.CREDENTIALS, new String[] { user, password });

			JMXConnectorServer jmxConnectorServer = JMXConnectorServerFactory.newJMXConnectorServer(url, map, mbServer);
			System.out.println("--------JMX���ӷ����������ɹ�--------");
			System.out.println("--------����JMX����----------");
			jmxConnectorServer.start();
			System.out.println("--------�����ɹ�-------------");
			
		} catch (Exception e) {
			System.out.println("��������");
			e.printStackTrace();
		} 
		
	}
}
