package com.mail.blackbox.util;

import java.util.ArrayList;
import java.util.Arrays;

public class ConstanceValue {

    public static final String TEST_CONTROLLER = "/blackboxTest";
    public static final String TEST_RESULT = "/result.jsp";
    
    public static final String OPTION_TEST_CONTROLLER = "optionTest";
    public static final String OPTION_TEST_RESULT = "/optionresult.jsp";
    public static final String OPTION_TEST_RESULT_VALUE = "optionTestResultValue";

    public static final String API_URL = "http://testapi.mail.naver.com/external/testapi?url=";
    
    public static final ArrayList<String> BOOLEAN_VALUE = new ArrayList<>(Arrays.asList("true", "false"));
    
    public static enum TestType{
	INVALID_TYPE("invalid value type test"), VALID_TYPE("valid value type test");
	
	private String testType;
	
	TestType(String testType){
	    this.testType = testType;
	}
	
	public String getTestType() {
	    return testType;
	}
    }


   

}
