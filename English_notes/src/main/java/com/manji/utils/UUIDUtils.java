package com.manji.utils;

import java.util.UUID;

public class UUIDUtils {
	/**
	 * 产生全球唯一的字符串
	 * @return
	 */
	public static String getUUid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
