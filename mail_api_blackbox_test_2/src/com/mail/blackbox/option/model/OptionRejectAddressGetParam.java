package com.mail.blackbox.option.model;

import java.util.ArrayList;

import com.mail.blackbox.model.Param;

public class OptionRejectAddressGetParam extends Param {
	private ArrayList<Param> domainList;
	private ArrayList<Param> mailList;

	public ArrayList<Param> getDomainList() {
		return domainList;
	}

	public void setDomainList(ArrayList<Param> domainList) {
		this.domainList = domainList;
	}

	public ArrayList<Param> getMailList() {
		return mailList;
	}

	public void setMailList(ArrayList<Param> mailList) {
		this.mailList = mailList;
	}

}
