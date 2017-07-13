package com.mail.blackbox.option.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mail.blackbox.model.MultiParamTestCase;
import com.mail.blackbox.model.Param;
import com.mail.blackbox.model.TestFault;
import com.mail.blackbox.option.model.OptionFolderListParam;
import com.mail.blackbox.option.util.OptionConstanceValue.OptionAPI;
import com.mail.blackbox.option.util.OptionSetConstanceValue.OptionFolderParam;
import com.mail.blackbox.util.ConstanceValue;
import com.mail.blackbox.util.UtilFunction;
import com.mail.blackbox.util.ConstanceValue.TestName;
import com.mail.blackbox.util.ConstanceValue.TestType;

public class OptionFolderDefaultTestServiceImpl implements OptionDefaultTestService {
    private static OptionDefaultTestService optionFolderDefaultTestServiceImple;
    private final String apiName = OptionAPI.FOLDER_LIST.api;
    private String apiURL;
    private MultiParamTestCase inValidTestCase;
    private MultiParamTestCase validTestCase;
    private HashSet<TestFault> result;
    
    static {
	optionFolderDefaultTestServiceImple = new OptionFolderDefaultTestServiceImpl();
    }
    
    private OptionFolderDefaultTestServiceImpl() {
	mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
	setTestCase();
	result = new HashSet<>();
    }
    
    

    public static OptionDefaultTestService getOptionFolderDefaultTestServiceImple() {
        return optionFolderDefaultTestServiceImple;
    }

    @Override
    public Param getCurrentOption() {
	apiURL = ConstanceValue.API_URL + OptionAPI.FOLDER_LIST.api;
	
	return pasingResponse(UtilFunction.request(apiURL, null));
    }

    @Override
    public Param pasingResponse(String response) {
	HashMap<String, Object> map = new HashMap<>();
	ArrayList<Param> folderList = new ArrayList<>();
	OptionFolderListParam pasingParam = new OptionFolderListParam();
	
	try {
	    map = mapper.readValue(response, new TypeReference<HashMap<String, Object>>() {
	        });
	    
	    for(String param : map.keySet()) {
		if(param.equals(OptionFolderParam.FOLDER_LIST.getParam())) {
		    folderList = mapper.readValue(response, new TypeReference<ArrayList<Param>>() {
		        });
		}
	    }
	    
	    pasingParam.setParams(map);
	    pasingParam.setFolderList(folderList);
	    
	} catch (JsonParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (JsonMappingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	return pasingParam;
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
