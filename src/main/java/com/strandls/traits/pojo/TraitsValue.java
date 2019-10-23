/**
 * 
 */
package com.strandls.traits.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Abhishek Rudra
 *
 */
@Entity
@Table(name = "trait_value")
public class TraitsValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2680415512611318294L;

	private Long id;
	private String value;
	private String icon;
	private Long traitInstanceId;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "icon")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "trait_instance_id")
	public Long getTraitInstanceId() {
		return traitInstanceId;
	}

	public void setTraitInstanceId(Long traitInstanceId) {
		this.traitInstanceId = traitInstanceId;
	}

}
