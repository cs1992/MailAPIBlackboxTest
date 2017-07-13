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

import com.mail.blackbox.model.Param;
import com.mail.blackbox.option.model.OptionFolderListParam;
import com.mail.blackbox.option.service.OptionFolderDefaultTestServiceImpl;

public class UtilFunction {

    public static List<String> getCommonTestCase() {
	List<String> testCase = new LinkedList<>();

	testCase.add("");
	testCase.add(" ");
	testCase.add(Integer.MAX_VALUE + "");
	testCase.add(Integer.MIN_VALUE + "");
	testCase.add(Long.MAX_VALUE + "");
	testCase.add(Long.MIN_VALUE + "");

	int size = 100;
	StringBuilder str = new StringBuilder();
	for (int i = 0; i < size; i++) {
	    str.append("naver");
	}
	testCase.add(str.toString());

	return testCase;
    }

    public static List<String> getNumberBetweenTestCase(List<String> value) {
	List<String> testCase = new LinkedList<>();

	int size = value.size();
	int temp;
	for (int i = 0; i < size; i++) {
	    temp = Integer.parseInt(value.get(i));
	    testCase.add((temp + 1) + "");
	    testCase.add((temp - 1) + "");
	}

	return testCase;
    }

    public static List<String> getNumberUnderUpperBetweenTestCase(List<String> value) {
	List<String> testCase = new LinkedList<>();
	int min, max;
	int size = value.size();
	int valueIndex = 0;

	if (size > 0) {
	    Collections.sort(value);
	    min = Integer.parseInt(value.get(0));
	    max = Integer.parseInt(value.get(size - 1));
	    min -= min / 2;
	    max += max / 2;

	    for (int i = min; i <= max; i++) {
		if (valueIndex < size && Integer.parseInt(value.get(valueIndex)) == i) {
		    valueIndex++;
		} else {
		    testCase.add(i + "");
		}
	    }
	}

	return testCase;
    }

    public static List<String> getAlpabetTestCase() {
	List<String> testCase = new LinkedList<>();

	for (char c = 'a'; c <= 'z'; c++) {
	    testCase.add(Character.toString(c));
	}

	for (char c = 'A'; c <= 'Z'; c++) {
	    testCase.add(Character.toString(c));
	}

	return testCase;
    }

    public static List<String> getBoolTestCase() {
	List<String> testCase = new LinkedList<>();

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

    public static ArrayList<String> getFolderSN() {
	ArrayList<String> folderSN = new ArrayList<>();
	ArrayList<Param> folderList = ((OptionFolderListParam) OptionFolderDefaultTestServiceImpl
		.getOptionFolderDefaultTestServiceImple().getCurrentOption()).getFolderList();

	int size = folderList.size();
	
	for(int i = 0; i < size; i++) {
	    folderSN.add((String) folderList.get(i).getParams().get("")); /////////////////
	}
	
	return folderSN;
    }
}
