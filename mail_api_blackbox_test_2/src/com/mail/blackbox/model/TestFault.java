package com.mail.blackbox.model;

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

}
