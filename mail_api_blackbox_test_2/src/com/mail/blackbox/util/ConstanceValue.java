package com.mail.blackbox.util;

public class ConstanceValue {

    public static final String TEST_CONTROLLER = "/blackboxTest";
    public static final String TEST_RESULT = "/testResult";
    
    public static final String OPTION_TEST_CONTROLLER = "optionTest";
    public static final String OPTION_TEST_RESULT = "/optionresult";

    public static final String API_URL = "http://testapi.mail.naver.com/external/testapi?url=";

    public static enum Reason {
	FAIL("fail"), NOT_SET_VALUE_SET_DEFAULT("not set value, set default"),
	
	UNDEFINED_ERROR("undefined error");

	public String result;

	private Reason(String result) {
	    this.result = result;
	}
    }

}
