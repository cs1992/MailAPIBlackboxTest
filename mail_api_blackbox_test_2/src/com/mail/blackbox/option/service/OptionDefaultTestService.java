package com.mail.blackbox.option.service;

import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.blackbox.model.Param;
import com.mail.blackbox.model.Result;

public interface OptionDefaultTestService {

    	ObjectMapper mapper = new ObjectMapper();
    
    
	Param getCurrentOption();
	
	Param pasingResponse(String response);
	
	void setOption(List<NameValuePair> params);
	
	List<Result> diffOption(Param originOption, Param afterOption, String testName, List<NameValuePair> params);
	
	List<Result> startTest();
	
	List<Result> singleParamTest();
	
	List<Result> multiParamTest();
}
