package com.ahnstar.skeleton.utils.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Cipher {
	/**
	 * 단방향 암호화를 한다. 
	 * @Method Name  	: SHAEncode
	 * @param str
	 * @return
	 */
	public static String SHAEncode(String str) {
		String SHA = "";
		try {

			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());

			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			SHA = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}

		return SHA;
	}
}
