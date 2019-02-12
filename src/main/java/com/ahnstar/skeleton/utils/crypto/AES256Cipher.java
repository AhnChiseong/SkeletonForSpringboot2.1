package com.ahnstar.skeleton.utils.crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AES256Cipher {
	private static volatile AES256Cipher INSTANCE;

	final static String secretKey = "186409919b2f4311bc592d11936a0397"; // 32bit
	static String IV = ""; // 16bit

	/**
	 * @Method Name : getInstance
	 * @Method 설명 : 기본 정보 셋팅
	 * @return
	 */
	private static AES256Cipher getInstance() {
		if (INSTANCE == null) {
			synchronized (AES256Cipher.class) {
				if (INSTANCE == null)
					INSTANCE = new AES256Cipher();
			}
		}
		return INSTANCE;
	}

	/**
	 * 키셋팅
	 */
	private AES256Cipher() {
		IV = secretKey.substring(0, 16);
	}

	/**
	 * @Method Name : AESEncode
	 * @Method 설명 : AES로 암호화처리
	 * @param str
	 * @param keyData
	 * @return
	 * @throws Exception
	 */
	public static String AESEncode(String str) throws Exception {
		byte[] keyData = secretKey.getBytes();
		SecretKey secureKey = new SecretKeySpec(keyData, "AES");

		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));

		byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
		String enStr = new String(Base64.encodeBase64(encrypted));

		return enStr;
	}

	/**
	 * @Method Name : AESDecode
	 * @Method 설명 : AES 복호화처리.
	 * @param str
	 * @param keyData
	 * @return
	 * @throws Exception
	 */
	public static String AESDecode(String str) throws Exception {
		byte[] keyData = secretKey.getBytes();
		SecretKey secureKey = new SecretKeySpec(keyData, "AES");
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));

		byte[] byteStr = Base64.decodeBase64(str.getBytes());

		return new String(c.doFinal(byteStr), "UTF-8");
	}
}
