package com.strandls.traits.pojo;

import java.util.List;
import java.util.Map;

import com.strandls.activity.pojo.MailData;

public class FactsCreateData {

	private MailData mailData;
//	to handle trait having preDefined Values
	private Map<Long, List<Long>> factValuePairs;
//	to Handle traits with user Entered Value
	private Map<Long, List<String>> factValueString;
	private Long pageTaxonId;

	/**
	 * 
	 */
	public FactsCreateData() {
		super();
	}

	/**
	 * @param mailData
	 * @param factValuePairs
	 * @param factValueString
	 * @param pageTaxonId
	 */
	public FactsCreateData(MailData mailData, Map<Long, List<Long>> factValuePairs,
			Map<Long, List<String>> factValueString, Long pageTaxonId) {
		super();
		this.mailData = mailData;
		this.factValuePairs = factValuePairs;
		this.factValueString = factValueString;
		this.pageTaxonId = pageTaxonId;
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

	public Map<Long, List<String>> getFactValueString() {
		return factValueString;
	}

	public void setFactValueString(Map<Long, List<String>> factValueString) {
		this.factValueString = factValueString;
	}

	public Long getPageTaxonId() {
		return pageTaxonId;
	}

	public void setPageTaxonId(Long pageTaxonId) {
		this.pageTaxonId = pageTaxonId;
	}

}
