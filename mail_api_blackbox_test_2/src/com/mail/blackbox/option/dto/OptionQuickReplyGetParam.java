package com.mail.blackbox.option.dto;

import java.util.ArrayList;

import com.mail.blackbox.dto.Param;

public class OptionQuickReplyGetParam extends Param  {
	private ArrayList<Param> quickReplyList;

	public ArrayList<Param> getQuickReplyList() {
		return quickReplyList;
	}

	public void setQuickReplyList(ArrayList<Param> quickReplyList) {
		this.quickReplyList = quickReplyList;
	}
	
	
}
