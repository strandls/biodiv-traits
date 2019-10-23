/**
 * 
 */
package com.strandls.traits.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Abhishek Rudra
 *
 */

@Entity
@Table(name = "trait_taxonomy_definition")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TraitTaxonomyDefinition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8895234511261039383L;
	private Long traitTaxonId;
	private Long taxonomyDefifintionId;

	@Id
	@Column(name = "trait_taxon_id")
	public Long getTraitTaxonId() {
		return traitTaxonId;
	}

	public void setTraitTaxonId(Long traitTaxonId) {
		this.traitTaxonId = traitTaxonId;
	}

	@Id
	@Column(name = "taxonomy_definition_id")
	public Long getTaxonomyDefifintionId() {
		return taxonomyDefifintionId;
	}

	public void setTaxonomyDefifintionId(Long taxonomyDefifintionId) {
		this.taxonomyDefifintionId = taxonomyDefifintionId;
	}

}
