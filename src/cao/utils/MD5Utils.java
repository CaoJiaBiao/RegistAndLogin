package cao.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	public static String getMD5(String password)
			throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bs = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();
		for (byte b : bs) {
			int i = b & 0xff;// 对低八位进行一个与运算
			// 把每个字节转成16进制
			String hexString = Integer.toHexString(i);// 转成16进制字符串

			if (hexString.length() < 2) {// 如果少于两位补一位
				hexString = "0" + hexString;

			}
			sb.append(hexString);
		}
		String md5Str = sb.toString();
		return md5Str;

	}
}
