/**
 * 
 */
package com.strandls.traits.pojo;

import io.swagger.annotations.ApiModel;

/**
 * @author Abhishek Rudra
 *
 */
@ApiModel
public class FactValuePair {

	private Long nameId;
	private String name;
	private Long valueId;
	private String value;
	private String type;
	private Boolean isParticipatry;

	/**
	 * 
	 */
	public FactValuePair() {
		super();
	}

	/**
	 * @param nameId
	 * @param name
	 * @param valueId
	 * @param value
	 * @param type
	 * @param isParticipatry
	 */
	public FactValuePair(Long nameId, String name, Long valueId, String value, String type, Boolean isParticipatry) {
		super();
		this.nameId = nameId;
		this.name = name;
		this.valueId = valueId;
		this.value = value;
		this.type = type;
		this.isParticipatry = isParticipatry;
	}

	public Long getNameId() {
		return nameId;
	}

	public void setNameId(Long nameId) {
		this.nameId = nameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getValueId() {
		return valueId;
	}

	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getIsParticipatry() {
		return isParticipatry;
	}

	public void setIsParticipatry(Boolean isParticipatry) {
		this.isParticipatry = isParticipatry;
	}

}
