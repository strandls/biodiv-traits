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
@Table(name = "trait")
public class Traits implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7750012729432714454L;
	private Long id;
	private String name;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
