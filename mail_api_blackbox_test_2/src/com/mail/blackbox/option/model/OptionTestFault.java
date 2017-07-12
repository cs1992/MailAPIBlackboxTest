package com.mail.blackbox.option.model;

import com.mail.blackbox.model.TestFault;
import com.mail.blackbox.option.util.OptionConstanceValue.OptionReason;

public class OptionTestFault extends TestFault {
    private OptionReason reason;
    private String originValue;
    private String defaultValue;
    private String afterValue;
  

    public OptionReason getReason() {
	return reason;
    }
    
    

    public String getAfterValue() {
        return afterValue;
    }



    public void setAfterValue(String afterValue) {
        this.afterValue = afterValue;
    }



    public void setReason(OptionReason reason) {
	this.reason = reason;
    }

    public String getOriginValue() {
	return originValue;
    }

    public void setOriginValue(String originValue) {
	this.originValue = originValue;
    }

    public String getDefaultValue() {
	return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
	this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();

	str.append(super.toString());
	str.append("\n<br>originValue : " + originValue);
	str.append("\n<br>defaultValue : " + defaultValue);
	str.append("\n<br>afterValue : " + afterValue);
	str.append("\n<br>reason : " + reason.result);

	return str.toString();
    }

}
