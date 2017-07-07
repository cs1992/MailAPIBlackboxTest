package com.mail.blackbox.option.list.dto;

import java.util.HashMap;

public class ListOptionParam {
    private HashMap<String, Object> params;
    
    public ListOptionParam() {
	params = new HashMap<>();
    }

    public HashMap<String, Object> getParams() {
	return params;
    }

    public void setParams(HashMap<String, Object> params) {
	this.params = params;
    }

}
