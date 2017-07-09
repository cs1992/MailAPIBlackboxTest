package com.mail.blackbox.option.dto;

import java.util.ArrayList;

import com.mail.blackbox.dto.Param;

public class OptionFilterGetParam extends Param {
	private ArrayList<Param> filterList;

	public ArrayList<Param> getFilterList() {
		return filterList;
	}

	public void setFilterList(ArrayList<Param> filterList) {
		this.filterList = filterList;
	}
	
	
}
