package com.mail.blackbox.model;

import java.util.Random;

public class TestFault {
    private String apiName;
    private String testName;
    private String paramName;
    private String testType;
    private String testValue;

    public TestFault() {

    }

    public String getTestType() {
	return testType;
    }

    public void setTestType(String testType) {
	this.testType = testType;
    }

    public String getTestValue() {
	return testValue;
    }

    public void setTestValue(String testValue) {
	this.testValue = testValue;
    }

    public String getTestName() {
	return testName;
    }

    public void setTestName(String testName) {
	this.testName = testName;
    }

    public String getParamName() {
	return paramName;
    }

    public void setParamName(String paramName) {
	this.paramName = paramName;
    }

    public String getApiName() {
	return apiName;
    }

    public void setApiName(String apiName) {
	this.apiName = apiName;
    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();

	str.append("\n<br>apiName : " + apiName);
	str.append("\n<br>testType : " + testType);
	str.append("\n<br>testName : " + testName);
	str.append("\n<br>paramName : " + paramName);
	str.append("\n<br>testValue : " + testValue);

	return str.toString();
    }
    
    @Override
    public int hashCode() {
//	Random random = new Random();
    	int hash = 3;//random.nextInt() / 2;
    	int len = testName.length();
    	
    	for(int i = 0; i < len; i++){
    		hash += testName.charAt(i);
    	}
    	
    	len = paramName.length();
    	
    	for(int i = 0; i < len; i++){
    		hash += paramName.charAt(i);
    	}
    	
    	len = testValue.length();
    	for(int i = 0; i < len; i++){
    		hash += testValue.charAt(i);
    	}
    	if(testName.length() !=0 && paramName.length() != 0 && testValue.length() != 0) {
    	    hash *= 31 + (testName.charAt(0) + paramName.charAt(0) + testValue.charAt(0));
    	    
    	}
    	
    	return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
    	TestFault tf = (TestFault)obj;
    	
    	if(testName.equals(tf.testName) && paramName.equals(tf.paramName) && testValue.equals(tf.testValue)){
    		return true;
    	} else {
    		return false;
    	}
    }

}
