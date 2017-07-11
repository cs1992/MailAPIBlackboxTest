package com.mail.blackbox.option.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.blackbox.model.Param;
import com.mail.blackbox.model.Result;
import com.mail.blackbox.option.model.OptionReadGetParam;
import com.mail.blackbox.option.util.OptionConstanceValue.OptionAPI;
import com.mail.blackbox.option.util.OptionConstanceValue.OptionReadSetParam;
import com.mail.blackbox.util.ConstanceValue;
import com.mail.blackbox.util.UtilFunction;

public class OptionReadDefaultTestServiceImple implements OptionDefaultTestService {

    private static OptionDefaultTestService optionReadDefaultTestServiceImple;
    private String apiURL;
    private Param pasing = new OptionReadGetParam();

    static {
	optionReadDefaultTestServiceImple = new OptionReadDefaultTestServiceImple();
    }

    private OptionReadDefaultTestServiceImple() {
//	mapper = new ObjectMapper();
	mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    }

    @Override
    public Param getCurrentOption() {
	apiURL = ConstanceValue.API_URL + OptionAPI.READ_GET.api;

	return pasingResponse(UtilFunction.request(apiURL, null));
    }

    @Override
    public void setOption(List<NameValuePair> params) {
	apiURL = ConstanceValue.API_URL + OptionAPI.READ_SET.api;

    }

    @Override
    public List<Result> diffOption(Param originOption, Param afterOption, String testName, List<NameValuePair> params) {
	
	return null;
    }

    @Override
    public List<Result> startTest() {

	return null;
    }

    @Override
    public Param pasingResponse(String response) {
	HashMap<String, Object> map = new HashMap<>();

	try {
	    map = mapper.readValue(response, new TypeReference<HashMap<String, Object>>() {
	    });
	    
	    pasing.setParams(map);
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
	return pasing;
    }

    @Override
    public List<Result> singleParamTest() {

	Param originValue = getCurrentOption();
	List<NameValuePair> params;
	List<String> values;
	for (OptionReadSetParam param : OptionReadSetParam.values()) {
	    
	    switch(param) {
	    case ACTION_AFTER_DELETE:
		
		break;
	    case FIRST_FOLDER_SN:
		
		break;
	    case FONT_NAME:
		
		break;
	    case POPUP_READ:
		
		break;
	    default:
		
		
	    }

	}
	return null;
    }

    @Override
    public List<Result> multiParamTest() {

	return null;
    }

}
