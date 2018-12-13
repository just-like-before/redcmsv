package com.redcmsv.test;

import java.lang.reflect.Field;

import com.redcmsv.beans.Channel;

public class Test1 {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Channel cl = new Channel();
		cl.setName("333");
		Class clazz = cl.getClass();
		try {
			Field f = clazz.getDeclaredField("name");
			f.setAccessible(true);
			System.out.println(f.get(cl));
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
