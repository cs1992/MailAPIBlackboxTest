package com.mail.blackbox.option.model;

import java.util.ArrayList;

import com.mail.blackbox.dto.Param;

public class OptionSignGetParam extends Param {
	private ArrayList<Param> signList;
	private ArrayList<Param> signInfoList;

	public ArrayList<Param> getSignList() {
		return signList;
	}

	public void setSignList(ArrayList<Param> signList) {
		this.signList = signList;
	}

	public ArrayList<Param> getSignInfoList() {
		return signInfoList;
	}

	public void setSignInfoList(ArrayList<Param> signInfoList) {
		this.signInfoList = signInfoList;
	}

}
