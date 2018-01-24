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
			int i = b & 0xff;// �ԵͰ�λ����һ��������
			// ��ÿ���ֽ�ת��16����
			String hexString = Integer.toHexString(i);// ת��16�����ַ���

			if (hexString.length() < 2) {// ���������λ��һλ
				hexString = "0" + hexString;

			}
			sb.append(hexString);
		}
		String md5Str = sb.toString();
		return md5Str;

	}
}
