package com.strandls.traits.pojo;

import java.util.List;
import java.util.Map;

import com.strandls.activity.pojo.MailData;

public class FactsCreateData {

	private MailData mailData;
	private Map<Long, List<Long>> factValuePairs;

	/**
	 * 
	 */
	public FactsCreateData() {
		super();
	}

	/**
	 * @param mailData
	 * @param factValuePairs
	 */
	public FactsCreateData(MailData mailData, Map<Long, List<Long>> factValuePairs) {
		super();
		this.mailData = mailData;
		this.factValuePairs = factValuePairs;
	}

	public MailData getMailData() {
		return mailData;
	}

	public void setMailData(MailData mailData) {
		this.mailData = mailData;
	}

	public Map<Long, List<Long>> getFactValuePairs() {
		return factValuePairs;
	}

	public void setFactValuePairs(Map<Long, List<Long>> factValuePairs) {
		this.factValuePairs = factValuePairs;
	}

}
