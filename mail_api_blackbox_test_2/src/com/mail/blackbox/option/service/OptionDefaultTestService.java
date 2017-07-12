package com.mail.blackbox.option.service;

import java.util.HashSet;
import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.blackbox.model.Param;
import com.mail.blackbox.model.TestFault;
import com.mail.blackbox.util.ConstanceValue.TestName;
import com.mail.blackbox.util.ConstanceValue.TestType;

public interface OptionDefaultTestService extends TestService {

    
	Param getCurrentOption();
	
	Param pasingResponse(String response);
	
	void setOption(List<NameValuePair> params);
	
	void diffOption(Param originOption, Param afterOption, TestName testName, List<NameValuePair> params, TestType testType);
	
	
	HashSet<TestFault> startIntegrationTest();
	
	void singleParamTest(TestType testType);
	
	void multiParamTest(TestType testType);
}
