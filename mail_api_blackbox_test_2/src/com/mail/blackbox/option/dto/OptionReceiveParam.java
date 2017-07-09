package com.mail.blackbox.option.dto;

import java.util.ArrayList;

import com.mail.blackbox.dto.Param;

public class OptionReceiveParam extends Param {
	private ArrayList<Param> addrList;
	private ArrayList<Param> mailingList;

	public ArrayList<Param> getAddrList() {
		return addrList;
	}

	public void setAddrList(ArrayList<Param> addrList) {
		this.addrList = addrList;
	}

	public ArrayList<Param> getMailingList() {
		return mailingList;
	}

	public void setMailingList(ArrayList<Param> mailingList) {
		this.mailingList = mailingList;
	}

}
