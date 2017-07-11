package com.mail.blackbox.model;

import java.util.*;

public class MultiParamTestCase {
	private Map<String, List<String>> multiParam;
	private List<Integer> multiParamIndex;
	private List<Integer> multiParamSize;
	private int paramMaxSize;

	public MultiParamTestCase(Map<String, List<String>> multiParam) {
		this.multiParam = multiParam;
		setMultiParamIndex();
		setMultiParamSize();
	}

	public int getParamMaxSize() {
		return paramMaxSize;
	}

	public void setParamMaxSize() {
		List<Integer> tempSize = new ArrayList<>();
		tempSize.addAll(multiParamSize);
		Collections.sort(tempSize);
		paramMaxSize = tempSize.get(tempSize.size() - 1);
	}

	public Map<String, List<String>> getMultiParam() {
		return multiParam;
	}

	private void setMultiParam(Map<String, List<String>> multiParam) {
		this.multiParam = multiParam;
	}

	public List<Integer> getMultiParamIndex() {
		return multiParamIndex;
	}

	public void setMultiParamIndex() {
		multiParamIndex = new ArrayList<>(multiParam.size());

	}

	public List<Integer> getMultiParamSize() {
		return multiParamSize;
	}

	private void setMultiParamSize() {
		multiParamSize = new ArrayList<>();

		for (String key : multiParam.keySet()) {
			multiParamSize.add(multiParam.get(key).size());
		}
	}
	
	public void resetIndex() {
		int size = multiParam.size();
		
		for(int i = 0; i < size; i++){
			multiParamIndex.set(i, 0);
		}
	}

	public Map<String, String> getNext() {
		Map<String, String> values = new HashMap<>();
		int i = 0;
		int index = 0;
		int paramIndexValue;

		for (String key : multiParam.keySet()) {
			paramIndexValue = multiParamIndex.get(i);
			if (paramIndexValue <= multiParamSize.get(i)) {
				multiParamIndex.set(i, 0);
				paramIndexValue = 0;
			}

			values.put(key, multiParam.get(key).get(paramIndexValue));
			multiParamIndex.set(i++, ++paramIndexValue);
		}

		return values;
	}

}
