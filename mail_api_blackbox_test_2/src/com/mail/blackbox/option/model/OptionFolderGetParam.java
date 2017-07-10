package com.mail.blackbox.option.model;

import java.util.ArrayList;

import com.mail.blackbox.model.Param;

public class OptionFolderGetParam extends Param  {
	private ArrayList<Param> folderList;

	public ArrayList<Param> getFolderList() {
		return folderList;
	}

	public void setFolderList(ArrayList<Param> folderList) {
		this.folderList = folderList;
	}
	
	
}
