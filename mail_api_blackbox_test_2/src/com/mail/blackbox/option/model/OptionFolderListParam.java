package com.mail.blackbox.option.model;

import java.util.ArrayList;

import com.mail.blackbox.model.Param;

public class OptionFolderListParam extends Param  {
	private ArrayList<Param> folderList;
	
	public OptionFolderListParam() {
	    folderList = new ArrayList<>();
	}

	public ArrayList<Param> getFolderList() {
		return folderList;
	}

	public void setFolderList(ArrayList<Param> folderList) {
		this.folderList = folderList;
	}
	
	
}
