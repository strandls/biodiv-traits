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
@Table(name = "fact")
public class Facts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1023668982266565625L;
	private Long id;
	private Boolean is_deleted;
	private Long object_id;
	private Long trait_instance_id;
	private Long trait_value_id;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "is_deleted")
	public Boolean getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(Boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Column(name = "object_id")
	public Long getObject_id() {
		return object_id;
	}

	public void setObject_id(Long object_id) {
		this.object_id = object_id;
	}

	@Column(name = "trait_instance_id")
	public Long getTrait_instance_id() {
		return trait_instance_id;
	}

	public void setTrait_instance_id(Long trait_instance_id) {
		this.trait_instance_id = trait_instance_id;
	}

	@Column(name = "trait_value_id")
	public Long getTrait_value_id() {
		return trait_value_id;
	}

	public void setTrait_value_id(Long trait_value_id) {
		this.trait_value_id = trait_value_id;
	}

}
