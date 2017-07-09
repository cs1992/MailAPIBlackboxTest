package com.mail.blackbox.option.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.mail.blackbox.dto.Param;

public class OptionWriteGetParam extends Param  {
	private ArrayList<Param> fromNameList;

	public ArrayList<Param> getFromNameList() {
		return fromNameList;
	}

	public void setFromNameList(ArrayList<Param> fromNameList) {
		this.fromNameList = fromNameList;
	}
	
	
}
