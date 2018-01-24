package cao.utils;

import java.util.UUID;

public class UUIDUtils {
	public static String getUID() {
		UUID randomUUID = UUID.randomUUID();
		String string = randomUUID.toString();
		String uid = string.replaceAll("-", "");

		return uid;
	}
}
