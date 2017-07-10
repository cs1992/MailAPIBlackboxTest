package com.mail.blackbox.option.model;

import java.util.ArrayList;

import com.mail.blackbox.model.Param;

public class OptionQuickReplyGetParam extends Param  {
	private ArrayList<Param> quickReplyList;

	public ArrayList<Param> getQuickReplyList() {
		return quickReplyList;
	}

	public void setQuickReplyList(ArrayList<Param> quickReplyList) {
		this.quickReplyList = quickReplyList;
	}
	
	
}
