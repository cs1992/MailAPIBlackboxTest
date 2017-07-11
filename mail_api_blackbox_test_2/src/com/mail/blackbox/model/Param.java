package com.mail.blackbox.model;

import java.util.HashMap;

public class Param {
    protected HashMap<String, Object> params;
    
    public Param() {
	params = new HashMap<>();
    }

    public HashMap<String, Object> getParams() {
	return params;
    }

    public void setParams(HashMap<String, Object> params) {
	this.params = params;
    }

}
