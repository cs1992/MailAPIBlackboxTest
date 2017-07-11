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
import com.mail.blackbox.model.Result;
import com.mail.blackbox.option.model.OptionListGetParam;
import com.mail.blackbox.option.model.OptionReadGetParam;
import com.mail.blackbox.option.util.OptionConstanceValue.OptionAPI;
import com.mail.blackbox.option.util.OptionConstanceValue.OptionListSetParam;
import com.mail.blackbox.util.ConstanceValue;
import com.mail.blackbox.util.ConstanceValue.Reason;
import com.mail.blackbox.util.Log;
import com.mail.blackbox.util.UtilFunction;

public class OptionListDefaultTestServiceImpl implements OptionDefaultTestService {

	private static OptionDefaultTestService optionListDefaultTestServiceImpl;
	private final String apiName = "List Default Test";
	private String apiURL;
	private MultiParamTestCase testCase;

	static {
		optionListDefaultTestServiceImpl = new OptionListDefaultTestServiceImpl();
	}

	private OptionListDefaultTestServiceImpl() {
		mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		setTestCase();

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

		Log.log(Arrays.toString(params.toArray()));
		UtilFunction.request(apiURL, params);
	}

	@Override
	public List<Result> diffOption(Param originOption, Param afterOption, String testName, List<NameValuePair> params) {
		List<Result> result = new LinkedList<>();
		Result r = new Result();
		OptionListGetParam listOriginOption = (OptionListGetParam) originOption;
		OptionListGetParam listAfterOption = (OptionListGetParam) afterOption;
		String originValue;
		String afterValue;
		int paramIndex;

		for (OptionListSetParam param : OptionListSetParam.values()) {
			r.setTestName(testName);
			r.setApiName(apiName);
			r.setParamName(param.param);
			originValue = String.valueOf(listOriginOption.getParams().get(param.param));
			afterValue = String.valueOf(listAfterOption.getParams().get(param.param));

			if (!originValue.equals(afterValue)) {
				if ((paramIndex = findParamIndex(param.param, params)) != -1) {
					if (!params.get(paramIndex).getValue().equals(afterValue) && !param.defValue.equals(afterValue)) {
						r.setReason(Reason.UNDEFINED_ERROR);
						result.add(r);
					}
				} else {
					if (afterValue.equals(param.defValue)) {
						r.setReason(Reason.NOT_SET_VALUE_SET_DEFAULT);
						result.add(r);
					} else {
						r.setReason(Reason.UNDEFINED_ERROR);
						result.add(r);
					}
				}
			}
		}

		return result;
	}

	@Override
	public List<Result> startTest() {

		return singleParamTest();
	}

	@Override
	public List<Result> singleParamTest() {

		final String testName = "Single Param Test";
		Param originOption = getCurrentOption();
		List<NameValuePair> originParams = setOriginParams(originOption);
		List<NameValuePair> params;
		List<String> values = new LinkedList<>();
		List<Result> result = new LinkedList<>();
		Param afterOption;
		int size;

		for (OptionListSetParam param : OptionListSetParam.values()) {
			switch (param) {
			case OPEN_FIRST_MAIL:
			case PREVIEW:
			case OMIT_SUBJECT:
			case USE_TO_TAG:
			case SHOW_RCPT:
			case HIDE_IMAGE_USE:
			case USE_VIP_MAIL_BOX:
			case USE_MULTIDEPTH:
				values = UtilFunction.getBoolTestCase(param.defValue);
				break;
			case DIVIDE_MODE:
				values = UtilFunction.getAlpabetTestCase(param.defValue);
				break;
			case LIST_NUM:

				values = UtilFunction.getNumberUnderUpperBetweenTestCase(
						new ArrayList<Integer>(Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40, 45, 60, 80)));
				break;
			case LIST_FONT_SIZE:

				values = UtilFunction
						.getNumberUnderUpperBetweenTestCase(new ArrayList<Integer>(Arrays.asList(8, 9, 10, 11, 12)));
				break;
			case PAGING_MODE:
				values = UtilFunction.getAlpabetTestCase(param.defValue);
				break;
			default:
			}

			size = values.size();
			for (int i = 0; i < size; i++) {
				params = new ArrayList<>();
				params.add(new BasicNameValuePair(param.param, values.get(i)));

				setOption(params);

				afterOption = getCurrentOption();
				setOption(originParams);

				result.addAll(diffOption(originOption, afterOption, testName, params));

			}
		}
		return result;
	}

	@Override
	public List<Result> multiParamTest() {
		final String testName = "Multi Param Test";

		Param originOption = getCurrentOption();
		List<NameValuePair> originParams = setOriginParams(originOption);
		List<NameValuePair> params;
		List<String> values = new LinkedList<>();
		List<Result> result = new LinkedList<>();
		Param afterOption;
		HashMap<String, String> tempMap;
		int size = testCase.getParamMaxSize();

		for (int i = 0; i < size; i++) {
			params = new ArrayList<>();
			tempMap = (HashMap<String, String>) testCase.getNext();

			for (String key : tempMap.keySet()) {
				params.add(new BasicNameValuePair(key, tempMap.get(key)));
			}
			setOption(params);

			afterOption = getCurrentOption();
			setOption(originParams);

			result.addAll(diffOption(originOption, afterOption, testName, params));

		}

		return result;
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

	private List<String> setTestValue(OptionListSetParam param) {
		List<String> temp = UtilFunction.getCommonTestCase();

		switch (param) {
		case OPEN_FIRST_MAIL:
		case PREVIEW:
		case OMIT_SUBJECT:
		case USE_TO_TAG:
		case SHOW_RCPT:
		case HIDE_IMAGE_USE:
		case USE_VIP_MAIL_BOX:
		case USE_MULTIDEPTH:
			temp.addAll(UtilFunction.getBoolTestCase(param.defValue));
			break;
		case DIVIDE_MODE:
			temp.addAll(UtilFunction.getAlpabetTestCase(param.defValue));
			break;
		case LIST_NUM:
			temp.addAll(UtilFunction.getNumberUnderUpperBetweenTestCase(
					new ArrayList<Integer>(Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40, 45, 60, 80))));
			break;
		case LIST_FONT_SIZE:
			temp.addAll(UtilFunction
					.getNumberUnderUpperBetweenTestCase(new ArrayList<Integer>(Arrays.asList(8, 9, 10, 11, 12))));
			break;
		case PAGING_MODE:
			temp.addAll(UtilFunction.getAlpabetTestCase(param.defValue));
			break;
		default:
		}
		return temp;
	}

	private void setTestCase() {
		Map<String, List<String>> multiParam = new HashMap<>();

		for (OptionListSetParam param : OptionListSetParam.values()) {
			multiParam.put(param.param, setTestValue(param));
			// switch (param) {
			// case OPEN_FIRST_MAIL:
			// case PREVIEW:
			// case OMIT_SUBJECT:
			// case USE_TO_TAG:
			// case SHOW_RCPT:
			// case HIDE_IMAGE_USE:
			// case USE_VIP_MAIL_BOX:
			// case USE_MULTIDEPTH:
			// multiParam.put(param.param,
			// UtilFunction.getBoolTestCase(param.defValue));
			// break;
			// case DIVIDE_MODE:
			// multiParam.put(param.param,
			// UtilFunction.getAlpabetTestCase(param.defValue));
			// break;
			// case LIST_NUM:
			//
			// multiParam.put(param.param,
			// UtilFunction.getNumberUnderUpperBetweenTestCase(
			// new ArrayList<Integer>(Arrays.asList(5, 10, 15, 20, 25, 30, 35,
			// 40, 45, 60, 80))));
			// break;
			// case LIST_FONT_SIZE:
			// multiParam.put(param.param, UtilFunction
			// .getNumberUnderUpperBetweenTestCase(new
			// ArrayList<Integer>(Arrays.asList(8, 9, 10, 11, 12))));
			// break;
			// case PAGING_MODE:
			// multiParam.put(param.param,
			// UtilFunction.getAlpabetTestCase(param.defValue));
			// break;
			// default:
			// }
		}

		this.testCase = new MultiParamTestCase(multiParam);

	}

}
