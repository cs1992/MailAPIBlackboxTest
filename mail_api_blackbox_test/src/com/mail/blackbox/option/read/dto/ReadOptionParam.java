package com.mail.blackbox.option.read.dto;

import java.util.HashMap;

public class ReadOptionParam {
    private HashMap<String , Object> params;
    
    public ReadOptionParam() {
	params = new HashMap<>();
    }

    public HashMap<String, Object> getParams() {
        return params;
    }

    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }
}
