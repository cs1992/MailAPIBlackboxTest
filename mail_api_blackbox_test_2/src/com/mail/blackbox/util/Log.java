package com.mail.blackbox.util;

public class Log {
    public static final boolean isLog = true;

    public static void log(String str) {
	if (isLog) {
	    System.out.println(str);
	}

    }

}
