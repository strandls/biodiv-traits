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
	private String traitTypes;
	private Boolean showInObservation;
	private Boolean isParticipatory;
	private Boolean isDeleted;
	private String source;

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

	@Column(name = "trait_types")
	public String getTraitTypes() {
		return traitTypes;
	}

	public void setTraitTypes(String traitTypes) {
		this.traitTypes = traitTypes;
	}

	@Column(name = "show_in_observation")
	public Boolean getShowInObservation() {
		return showInObservation;
	}

	public void setShowInObservation(Boolean showInObservation) {
		this.showInObservation = showInObservation;
	}

	@Column(name = "is_participatory")
	public Boolean getIsParticipatory() {
		return isParticipatory;
	}

	public void setIsParticipatory(Boolean isParticipatory) {
		this.isParticipatory = isParticipatory;
	}

	@Column(name = "is_deleted")
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	@Column(name = "source")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	
}
