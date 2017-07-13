package com.mail.blackbox.option.service;

import java.io.IOException;
import java.util.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mail.blackbox.model.MultiParamTestCase;
import com.mail.blackbox.model.Param;
import com.mail.blackbox.model.TestFault;
import com.mail.blackbox.option.model.OptionListGetParam;
import com.mail.blackbox.option.model.OptionTestFault;
import com.mail.blackbox.option.util.OptionConstanceValue;
import com.mail.blackbox.option.util.OptionConstanceValue.OptionAPI;
import com.mail.blackbox.option.util.OptionConstanceValue.OptionReason;
import com.mail.blackbox.option.util.OptionSetConstanceValue.OptionListSetParam;
import com.mail.blackbox.util.ConstanceValue;
import com.mail.blackbox.util.Log;
import com.mail.blackbox.util.UtilFunction;
import com.mail.blackbox.util.ConstanceValue.TestName;
import com.mail.blackbox.util.ConstanceValue.TestType;

public class OptionListDefaultTestServiceImpl implements OptionDefaultTestService {

    private static OptionDefaultTestService optionListDefaultTestServiceImpl;
    private final String apiName = OptionAPI.LIST_SET.api;
    private String apiURL;
    private MultiParamTestCase inValidTestCase;
    private MultiParamTestCase validTestCase;
    private HashSet<TestFault> result;

    static {
	optionListDefaultTestServiceImpl = new OptionListDefaultTestServiceImpl();
    }

    private OptionListDefaultTestServiceImpl() {
	mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
	setTestCase();
	result = new HashSet<>();

    }

    public static OptionDefaultTestService getOptionListDefaultTestServiceImpl() {
	return optionListDefaultTestServiceImpl;
    }

    @Override
    public Param getCurrentOption() {
	apiURL = ConstanceValue.API_URL + OptionAPI.LIST_GET.api;

	return pasingResponse(UtilFunction.request(apiURL, null));
    }

    @Override
    public Param pasingResponse(String response) {
	// Log.log(response);
	HashMap<String, Object> map = new HashMap<>();
	Param pasingParam = new OptionListGetParam();

	try {
	    map = mapper.readValue(response, new TypeReference<HashMap<String, Object>>() {
	    });

	    pasingParam.setParams(map);
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
	apiURL = ConstanceValue.API_URL + OptionAPI.LIST_SET.api;

	// Log.log("Set Param : " + Arrays.toString(params.toArray()));
	UtilFunction.request(apiURL, params);
    }

    public void setOriginOption(List<NameValuePair> params) {
	apiURL = ConstanceValue.API_URL + OptionAPI.LIST_SET.api;

	UtilFunction.request(apiURL, params);
    }

    @Override
    public void diffOption(Param originOption, Param afterOption, TestName testName, List<NameValuePair> params,
	    TestType testType) {

	OptionTestFault r = new OptionTestFault();
	OptionListGetParam listOriginOption = (OptionListGetParam) originOption;
	OptionListGetParam listAfterOption = (OptionListGetParam) afterOption;
	String originValue;
	String afterValue;
	String defValue;
	String setValue;
	String paramName;
	int paramIndex;

	for (OptionListSetParam param : OptionListSetParam.values()) {

	    paramName = param.param;
	    originValue = String.valueOf(listOriginOption.getParams().get(paramName));
	    afterValue = String.valueOf(listAfterOption.getParams().get(paramName));
	    defValue = param.defValue;
	    paramIndex = findParamIndex(paramName, params);
	    setValue = paramIndex == -1 ? "" : params.get(paramIndex).getValue();

	    r = new OptionTestFault();
	    r.setTestName(testName.getTestName());
	    r.setApiName(apiName);
	    r.setParamName(paramName);
	    r.setTestValue(setValue);
	    r.setDefaultValue(defValue);
	    r.setOriginValue(originValue);
	    r.setAfterValue(afterValue);
	    r.setTestType(testType.getTestType());

	    if (paramIndex == -1) {
		if (!originValue.equals(afterValue)) {
		    if (afterValue.equals(defValue)) {
			r.setReason(OptionReason.NOT_SET_BUT_SET_DEFAULT); // 보류?????
			result.add(r);
			// 설정 x, set default
		    } else {
			r.setReason(OptionReason.NOT_SET_BUT_SET_UNDEFINED);
			result.add(r);
			// set x, set undefined
		    }
		}
	    } else {
		if (originValue.equals(afterValue)) {
		    if (!originValue.equals(defValue) && !originValue.equals(setValue)) {
			r.setReason(OptionReason.UNDEFIND);
			result.add(r);
			// set o, not c
		    }
		} else {
		    if (isValidData(param, setValue)) {
			if (!setValue.equals(afterValue)) {
			    r.setReason(OptionReason.SET_VALID_BUT_NOT_SET);
			    result.add(r);
			    // set valid value, but not set
			}
		    } else {
			if (setValue.equals(afterValue)) {
			    r.setReason(OptionReason.SET_INVALID_VALUE);
			    result.add(r);
			    // set invalid value
			} else {
			    if (!afterValue.equals(defValue)) {
				r.setReason(OptionReason.SET_INVALID_BUT_NOT_SET_DEFAULT);
				result.add(r);
				// set invalid value, but not set default
			    }
			}
		    }

		}
	    }

	}

    }

    @Override
    public HashSet<TestFault> startIntegrationTest() {

	for (TestType testType : TestType.values()) {
	    multiParamTest(testType);
	     singleParamTest(testType);
	}

	return result;
    }

    @Override
    public void singleParamTest(TestType testType) {

	Param originOption = getCurrentOption();
	List<NameValuePair> originParams = setOriginParams(originOption);
	List<NameValuePair> params;
	List<String> values = new LinkedList<>();
	Param afterOption;
	HashMap<String, String> tempMap;

	MultiParamTestCase testCase = testType == TestType.INVALID_TYPE ? inValidTestCase : validTestCase;

	int size = testCase.getParamMaxSize();
	

	for (int i = 0; i < size; i++) {
	    params = new ArrayList<>();
	    tempMap = (HashMap<String, String>) testCase.getNext();
	    int mapSize = tempMap.size() / 2;
	    int mapCount = 0;
	    for (String key : tempMap.keySet()) {
		
		if(mapCount++ >= mapSize) {
		    break;
		}
		
		params = new LinkedList<>();
		params.add(new BasicNameValuePair(key, tempMap.get(key)));

		setOption(params);

		afterOption = getCurrentOption();
		setOriginOption(originParams);

		diffOption(originOption, afterOption, TestName.SINGLE_PARAM_TEST, params, testType);
	    }

	}

	
    }

    @Override
    public void multiParamTest(TestType testType) {

	Param originOption = getCurrentOption();
	List<NameValuePair> originParams = setOriginParams(originOption);
	List<NameValuePair> params;
	List<String> values = new LinkedList<>();
	Param afterOption;
	HashMap<String, String> tempMap;

	MultiParamTestCase testCase = testType == TestType.INVALID_TYPE ? inValidTestCase : validTestCase;

	int size = testCase.getParamMaxSize();

	for (int i = 0; i < size; i++) {
	    params = new ArrayList<>();
	    tempMap = (HashMap<String, String>) testCase.getNext();

	    for (String key : tempMap.keySet()) {
		params.add(new BasicNameValuePair(key, tempMap.get(key)));
	    }
	    setOption(params);

	    afterOption = getCurrentOption();
	    setOriginOption(originParams);

	    diffOption(originOption, afterOption, TestName.MULTI_PARAM_TEST, params, testType);

	}

    }

    private int findParamIndex(String param, List<NameValuePair> params) {
	int index = -1;

	int size = params.size();

	for (int i = 0; i < size; i++) {
	    if (param.equals(params.get(i).getName())) {
		index = i;
		break;
	    }
	}

	return index;
    }

    private List<NameValuePair> setOriginParams(Param originOption) {
	List<NameValuePair> originParams = new LinkedList<>();
	HashMap<String, Object> map = originOption.getParams();
	for (String key : map.keySet()) {
	    originParams.add(new BasicNameValuePair(key, String.valueOf(map.get(key))));
	}

	return originParams;
    }

    @Override
    public void setTestCase() {
	Map<String, List<String>> multiParam;

	for (TestType testType : TestType.values()) {
	    multiParam = new HashMap<>();

	    for (OptionListSetParam param : OptionListSetParam.values()) {
		multiParam.put(param.param, param.getTestValues(param, testType));
	    }

	    if (testType == TestType.INVALID_TYPE) {

		this.inValidTestCase = new MultiParamTestCase(multiParam);
	    } else {

		this.validTestCase = new MultiParamTestCase(multiParam);
	    }
	}

    }

    private boolean isValidData(OptionListSetParam param, String value) {

	boolean isValid = false;
	ArrayList<String> validValues = param.getTestValues(param, TestType.VALID_TYPE);

	int size = validValues.size();

	for (int i = 0; i < size; i++) {
	    if (value.equals(validValues.get(i))) {
		isValid = true;
		break;
	    }
	}

	return isValid;
    }

}
