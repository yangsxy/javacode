package com.mbean;

public class SimpleStandard implements SimpleStandardMBean{

	public String name;
	public int getAge() {
		return 24;
	}

	public String getName(String name) {
		this.name=name;
		System.out.println("----------调用了getName方法----------");
		return this.name;
	}

	public void reSet() {
		System.out.println("----------reSet()-----------");
	}

	public void setName(String name) {
		this.name=name;		
	}

	public void aaa(){
		System.out.println("aaa");
	}

	@Override
	public String getInfo(String name, String age, String address) {
		
		// TODO Auto-generated method stub
		return name+"("+age+"岁)地址："+address;
		
	}

}
