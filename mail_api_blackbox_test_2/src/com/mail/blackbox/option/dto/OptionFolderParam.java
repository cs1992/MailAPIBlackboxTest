package com.mail.blackbox.option.dto;

import java.util.ArrayList;

import com.mail.blackbox.dto.Param;

public class OptionFolderParam extends Param  {
	private ArrayList<Param> folderList;

	public ArrayList<Param> getFolderList() {
		return folderList;
	}

	public void setFolderList(ArrayList<Param> folderList) {
		this.folderList = folderList;
	}
	
	
}