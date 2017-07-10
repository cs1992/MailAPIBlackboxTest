package com.mail.blackbox.util;

public class ConstanceValue {

	public static final String OPTION_TEST_CONTROLLER = "optionTest";
	public static final String OPTION_TEST_RESULT = "/optionresult";
	
	public static final String API_URL = "http://testapi.mail.naver.com/external/testapi?url=";
	
	
	public static enum TestResult {
		SUCCESS("s"), FAIL("f");
		
		public String result;
		
		private TestResult(String result) {
			this.result = result;
		}
	}

}
