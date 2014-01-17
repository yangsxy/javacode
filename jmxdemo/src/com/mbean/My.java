package com.mbean;

public class My implements MyMBean {

	public String getInfo(String name) {
		return "info="+name;
	}

	public int add(int a, int b) {
		
		return a+b;
	}

}

