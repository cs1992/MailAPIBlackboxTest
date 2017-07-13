package com.mail.blackbox.option.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mail.blackbox.model.Param;
import com.mail.blackbox.model.TestFault;
import com.mail.blackbox.option.model.OptionReadGetParam;
import com.mail.blackbox.option.util.OptionConstanceValue.OptionAPI;
import com.mail.blackbox.option.util.OptionSetConstanceValue.OptionReadSetParam;
import com.mail.blackbox.util.ConstanceValue;
import com.mail.blackbox.util.ConstanceValue.TestName;
import com.mail.blackbox.util.ConstanceValue.TestType;
import com.mail.blackbox.util.UtilFunction;

public class OptionReadDefaultTestServiceImple implements OptionDefaultTestService {

	@Override
	public Param getCurrentOption() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Param pasingResponse(String response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOption(List<NameValuePair> params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void diffOption(Param originOption, Param afterOption, TestName testName, List<NameValuePair> params,
			TestType testType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashSet<TestFault> startIntegrationTest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void singleParamTest(TestType testType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void multiParamTest(TestType testType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTestCase() {
	    // TODO Auto-generated method stub
	    
	}

	



}
