package com.nutsaboutcandies.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMaker {
	public static String makeHash(String text) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(text.getBytes());
		byte[] bytes = md.digest();
		StringBuffer sb = new StringBuffer();
		for(byte b: bytes) {
			sb.append(Integer.toString((b & 0xFF) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
