package com.mail.blackbox.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class UtilFunction {
	
	public static List<String> getCommonTestCase(){
		List<String> testCase = new LinkedList<>();
		
		testCase.add("");
		testCase.add(" ");
		testCase.add(Integer.MAX_VALUE + "");
		testCase.add(Integer.MIN_VALUE + "");
		testCase.add(Long.MAX_VALUE + "");
		testCase.add(Long.MIN_VALUE + "");
		
		int size = 100;
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < size; i++){
			str.append("naver");
		}
		testCase.add(str.toString());
		
		return testCase;
	}

	public static List<String> getNumberUnderUpperBetweenTestCase(List<Integer> value) {
		List<String> testCase = new LinkedList<>();
		int min, max;
		int size = value.size();
		int valueIndex = 0;

		if (size > 0) {
			Collections.sort(value);
			min = value.get(0) - 10;
			max = value.get(size - 1) + 10;

			for (int i = min; i <= max; i++) {
				if (valueIndex < size && value.get(valueIndex) == i) {
					valueIndex++;
				} else {
					testCase.add(i + "");
				}
			}
		}

		return testCase;
	}

	public static List<String> getAlpabetTestCase(String defValue) {
		List<String> testCase = new LinkedList<>();

		for (char c = 'a'; c <= 'z'; c++) {
			testCase.add(Character.toString(c));
		}

		for (char c = 'A'; c <= 'Z'; c++) {
			testCase.add(Character.toString(c));
		}

		return testCase;
	}

	public static List<String> getBoolTestCase(String defValue) {
		List<String> testCase = new LinkedList<>();
		String value;
		final String TRUE = "true";
		final String FALSE = "false";

		if (TRUE.equals(defValue)) {
			testCase.add(FALSE);
			value = FALSE;
		} else {
			testCase.add(TRUE);
			value = TRUE;
		}

		testCase.add("tttt");
		testCase.add("fffff");
		testCase.add("truefalse");
		testCase.add("falsetrue");
		testCase.add("TRUE");
		testCase.add("FALSE");
		testCase.add("t");
		testCase.add("f");
		testCase.add("T");
		testCase.add("F");
		testCase.add("0");
		testCase.add("1");

		return testCase;
	}

	public static String request(String apiURL, List<NameValuePair> params) {
		String result = null;
		if (params == null) {
			params = new ArrayList<>();
		}

		try {
			HttpClient client = HttpClientBuilder.create().build();
			URI uri = new URI(apiURL);
			HttpPost post = new HttpPost(uri);

			UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
			post.setEntity(ent);
			HttpResponse httpPost = client.execute(post);
			HttpEntity entity = httpPost.getEntity();
			result = EntityUtils.toString(entity);

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}
