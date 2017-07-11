package com.mail.blackbox.model;


import com.mail.blackbox.util.ConstanceValue.Reason;

public class Result {
    private String apiName;
    private String testName;
    private String paramName;
    private Reason reason;
    private int errorCount;

    public Result() {
	
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

    public Reason getReason() {
	return reason;
    }

    public void setReason(Reason reason) {
	this.reason = reason;
    }

    public String getApiName() {
	return apiName;
    }

    public void setApiName(String apiName) {
	this.apiName = apiName;
    }

    public int getErrorCount() {
	return errorCount;
    }

    public void setErrorCount(int errorCount) {
	this.errorCount = errorCount;
    }

}
