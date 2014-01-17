package com;

import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class Client {
	public static void main(String[] args) {
		try {
			String ip = "192.168.0.77";
			int port = 40000;
			String user = "admin";
			String password = "admin";
			//创建jmx连接
			JMXServiceURL jmxUrl = new JMXServiceURL("service:jmx:rmi://" + ip + ":" + port + "/jndi/rmi://" + ip + ":" + port + "/server");
			Map<String, Object> map=new HashMap<String,Object>();
//			map.put("jmx.remote.protocol.provider.pkgs", "org.logicblaze.lingo.jmx.remote.provider");
			map.put(JMXConnector.CREDENTIALS, new String[] { user, password });
			JMXConnector jmxConn=JMXConnectorFactory.connect(jmxUrl,map);
			//获得MBean服务连接
			MBeanServerConnection mbsConn=jmxConn.getMBeanServerConnection();
//			String defaultDedomain=mbsConn.getDefaultDomain();
			ObjectName objname= new ObjectName("INTERWORK:type=Container,name=Router");
			Object[] para={"yang"};//参数名
			String[] paraType={"java.lang.String"};//参数类型
			Object str=mbsConn.invoke(objname, "invoke", para, paraType);//调用服务端的方法
			System.out.println("rerult:" + str.toString());
			
//			MBeanServerConnection mbsConn=jmxConn.getMBeanServerConnection();
//			String defaultDedomain=mbsConn.getDefaultDomain();
//			ObjectName objname= new ObjectName(defaultDedomain + ":name=mytest");
//			Object[] para={"yang"};//参数名
//			String[] paraType={"java.lang.String"};//参数类型
//			Object str=mbsConn.invoke(objname, "getInfo", para, paraType);//调用服务端的方法
//			System.out.println("rerult:" + str.toString());
//			
//			System.out.println("======================================================================");
//			
//			ObjectName objnameA= new ObjectName(defaultDedomain + ":name=simpletest");
//			Object[] paraA={"yang","23","成都高新区"};//参数名
//			String[] paraTypeA={"java.lang.String","java.lang.String","java.lang.String"};//参数类型
//			Object strA=mbsConn.invoke(objnameA, "getInfo", paraA, paraTypeA);//调用服务端的方法
//			System.out.println("rerult:" + strA.toString());
			
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}
}
