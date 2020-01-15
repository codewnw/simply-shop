package com.simplyshop.util;

public class IdGenerator {

	public static String getNewItemId() {
		return "ITEM" + System.currentTimeMillis();
	}

}
