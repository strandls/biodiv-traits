package com.strandls.traits.pojo;

import java.util.List;

import com.strandls.activity.pojo.MailData;

public class FactsUpdateData {

	private MailData mailData;
	private List<Long> traitValueList;

	/**
	 * 
	 */
	public FactsUpdateData() {
		super();
	}

	/**
	 * @param mailData
	 * @param traitValueList
	 */
	public FactsUpdateData(MailData mailData, List<Long> traitValueList) {
		super();
		this.mailData = mailData;
		this.traitValueList = traitValueList;
	}

	public MailData getMailData() {
		return mailData;
	}

	public void setMailData(MailData mailData) {
		this.mailData = mailData;
	}

	public List<Long> getTraitValueList() {
		return traitValueList;
	}

	public void setTraitValueList(List<Long> traitValueList) {
		this.traitValueList = traitValueList;
	}

}
