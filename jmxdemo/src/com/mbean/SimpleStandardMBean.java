package com.mbean;

public interface SimpleStandardMBean {

	public void setName(String name);
	
	public String getName(String name);
	
	public void reSet();
	
	public int getAge();
	
	public String getInfo(String name,String age,String address);
}
