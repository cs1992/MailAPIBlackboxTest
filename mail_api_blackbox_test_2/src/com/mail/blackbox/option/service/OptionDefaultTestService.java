package com.mail.blackbox.option.service;

import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.blackbox.model.Param;
import com.mail.blackbox.model.TestFault;
import com.mail.blackbox.util.ConstanceValue.TestType;

public interface OptionDefaultTestService extends TestService {

    
	Param getCurrentOption();
	
	Param pasingResponse(String response);
	
	void setOption(List<NameValuePair> params);
	
	List<TestFault> diffInvalidOption(Param originOption, Param afterOption, String testName, List<NameValuePair> params, TestType testType);
	
	List<TestFault> diffValidOption(Param originOption, Param afterOption, String testName, List<NameValuePair> params);
	
	List<TestFault> startIntegrationTest();
	
	List<TestFault> singleParamTest();
	
	List<TestFault> multiParamTest(TestType testType);
}
