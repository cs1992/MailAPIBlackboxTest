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
	private final String apiName = "List Default Test";
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
		Log.log(response);
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

		Log.log("Set Param : " + Arrays.toString(params.toArray()));
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

			if (originValue.equals(afterValue)) {
				if (paramIndex == -1) {
					// ok
				} else {
					if (originValue.equals(defValue)) {// ||
						// originValue.equals(afterValue))
						// {
						// ok
					} else {
						r.setReason(OptionReason.UNDEFINED_ERROR);
						result.add(r);
						// ?
					}
				}

				// 값이 변하지 않았다.
//				if (paramIndex != -1 && !originValue.equals(defValue)) {
//					// set 한 값이면서, 디폴트 값이 아니면
//					r.setReason(OptionReason.UNDEFINED_ERROR);
//					result.add(r);
//				}

			} else {
				if (paramIndex == -1) {
					if (afterValue.equals(defValue)) {
						r.setReason(OptionReason.NOT_SET_VALUE_SET_DEFAULT);
						result.add(r);
						// ex
					} else {
						r.setReason(OptionReason.NOT_SET_VALUE_SET_UNDEFINED_VALUE);
						result.add(r);
						// ex
					}

				} else {
					if (isValidData(param, afterValue)) {
						// if(isValidData(param, setValue))

						// if (afterValue.equals(defValue)) {
						// // ok
						// } else {
						// r.setReason(OptionReason.SET_VALUE_VALID_BUT_NOT_DEFAULT);
						// result.add(r);
						// // ex
						// }
						if (!afterValue.equals(defValue) && !afterValue.equals(setValue)) {
							r.setReason(OptionReason.SET_VALUE_VALID_BUT_NOT_DEFAULT);
							result.add(r);
							// ex
						}
					} else {
						if (setValue.equals(afterValue)) {
							r.setReason(OptionReason.SET_VALUE_SET_INVALIED_VALUE);
							result.add(r);
							// ex
						} else {
							r.setReason(OptionReason.SET_VALUE_SET_UNDEFINED_VALUE);
							result.add(r);
							// ex
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

			for (String key : tempMap.keySet()) {
				params.add(new BasicNameValuePair(key, tempMap.get(key)));

				setOption(params);

				afterOption = getCurrentOption();
				setOriginOption(originParams);

				diffOption(originOption, afterOption, TestName.SINGLE_PARAM_TEST, params, testType);
			}

		}

		// Param originOption = getCurrentOption();
		// List<NameValuePair> originParams = setOriginParams(originOption);
		// List<NameValuePair> params;
		// List<String> values = new LinkedList<>();
		// List<TestFault> result = new LinkedList<>();
		// Param afterOption;
		// int size;
		//
		// for (OptionListSetParam param : OptionListSetParam.values()) {
		// switch (param) {
		// case OPEN_FIRST_MAIL:
		// case PREVIEW:
		// case OMIT_SUBJECT:
		// case USE_TO_TAG:
		// case SHOW_RCPT:
		// case HIDE_IMAGE_USE:
		// case USE_VIP_MAIL_BOX:
		// case USE_MULTIDEPTH:
		// values = UtilFunction.getBoolTestCase(param.defValue);
		// break;
		// case DIVIDE_MODE:
		// values = UtilFunction.getAlpabetTestCase(param.defValue);
		// break;
		// case LIST_NUM:
		//
		// values = UtilFunction.getNumberUnderUpperBetweenTestCase(
		// new ArrayList<Integer>(Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40,
		// 45, 60,
		// 80)));
		// break;
		// case LIST_FONT_SIZE:
		//
		// values = UtilFunction
		// .getNumberUnderUpperBetweenTestCase(new
		// ArrayList<Integer>(Arrays.asList(8,
		// 9, 10, 11, 12)));
		// break;
		// case PAGING_MODE:
		// values = UtilFunction.getAlpabetTestCase(param.defValue);
		// break;
		// default:
		// }
		//
		// size = values.size();
		// for (int i = 0; i < size; i++) {
		// params = new ArrayList<>();
		// params.add(new BasicNameValuePair(param.param, values.get(i)));
		//
		// setOption(params);
		//
		// afterOption = getCurrentOption();
		// setOption(originParams);
		//
		// result.addAll(diffInvalidOption(originOption, afterOption,
		// OptionConstanceValue.SINGLE_PARAM_TEST, params));
		//
		// }
		// }
		// return result;
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

	private void setTestCase() {
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
