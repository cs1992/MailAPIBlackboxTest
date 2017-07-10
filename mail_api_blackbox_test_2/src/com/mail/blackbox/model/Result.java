package com.mail.blackbox.model;

import java.util.HashMap;

import com.mail.blackbox.util.ConstanceValue.TestResult;

public class Result {
	private HashMap<String, TestResult> result;

	public HashMap<String, TestResult> getResult() {
		return result;
	}

	public void setResult(HashMap<String, TestResult> result) {
		this.result = result;
	}
	
	
}
