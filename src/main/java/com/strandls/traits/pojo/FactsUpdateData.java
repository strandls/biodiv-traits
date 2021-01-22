package com.strandls.traits.pojo;

import java.util.List;

import com.strandls.activity.pojo.MailData;

public class FactsUpdateData {

	private MailData mailData;
	private List<Long> traitValueList;
	private List<String> valuesString;
	private Long pageTaxonId;

	/**
	 * 
	 */
	public FactsUpdateData() {
		super();
	}

	/**
	 * @param mailData
	 * @param traitValueList
	 * @param valuesString
	 * @param pageTaxonId
	 */
	public FactsUpdateData(MailData mailData, List<Long> traitValueList, List<String> valuesString, Long pageTaxonId) {
		super();
		this.mailData = mailData;
		this.traitValueList = traitValueList;
		this.valuesString = valuesString;
		this.pageTaxonId = pageTaxonId;
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

	public List<String> getValuesString() {
		return valuesString;
	}

	public void setValuesString(List<String> valuesString) {
		this.valuesString = valuesString;
	}

	public Long getPageTaxonId() {
		return pageTaxonId;
	}

	public void setPageTaxonId(Long pageTaxonId) {
		this.pageTaxonId = pageTaxonId;
	}

}
