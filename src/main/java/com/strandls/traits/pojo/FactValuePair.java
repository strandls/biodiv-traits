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

	private String name;
	private String value;
	
	public FactValuePair(String name, String value){
		this.name=name;
		this.value=value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
