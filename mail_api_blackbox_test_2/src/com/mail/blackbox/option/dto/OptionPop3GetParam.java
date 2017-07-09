package com.mail.blackbox.option.dto;

import java.util.ArrayList;

import com.mail.blackbox.dto.Param;

public class OptionPop3GetParam extends Param {
	private ArrayList<Param> extPop3OptionList;
	private ArrayList<Param> folderList;

	public ArrayList<Param> getExtPop3OptionList() {
		return extPop3OptionList;
	}

	public void setExtPop3OptionList(ArrayList<Param> extPop3OptionList) {
		this.extPop3OptionList = extPop3OptionList;
	}

	public ArrayList<Param> getFolderList() {
		return folderList;
	}

	public void setFolderList(ArrayList<Param> folderList) {
		this.folderList = folderList;
	}

}
