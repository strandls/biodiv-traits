/**
 * 
 */
package com.strandls.traits.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	private Long version;
	private String attribution;
	private Long contributorId;
	private Boolean isDeleted;
	private Long licenseId;
	private Long objectId;
	private Long pageTaxonId;
	private Long traitInstanceId;
	private Long traitValueId;
	private String value;
	private String objectType;
	private String toValue;
	private Date fromDate;
	private Date toDate;
	private Long dataTableId;

	/**
	 * 
	 */
	public Facts() {
		super();
	}

	/**
	 * @param id
	 * @param version
	 * @param attribution
	 * @param contributorId
	 * @param isDeleted
	 * @param licenseId
	 * @param objectId
	 * @param pageTaxonId
	 * @param traitInstanceId
	 * @param traitValueId
	 * @param value
	 * @param objectType
	 * @param toValue
	 * @param fromDate
	 * @param toDate
	 * @param dataTableId
	 */
	public Facts(Long id, Long version, String attribution, Long contributorId, Boolean isDeleted, Long licenseId,
			Long objectId, Long pageTaxonId, Long traitInstanceId, Long traitValueId, String value, String objectType,
			String toValue, Date fromDate, Date toDate, Long dataTableId) {
		super();
		this.id = id;
		this.version = version;
		this.attribution = attribution;
		this.contributorId = contributorId;
		this.isDeleted = isDeleted;
		this.licenseId = licenseId;
		this.objectId = objectId;
		this.pageTaxonId = pageTaxonId;
		this.traitInstanceId = traitInstanceId;
		this.traitValueId = traitValueId;
		this.value = value;
		this.objectType = objectType;
		this.toValue = toValue;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.dataTableId = dataTableId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "version")
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name = "attribution")
	public String getAttribution() {
		return attribution;
	}

	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}

	@Column(name = "contributor_id")
	public Long getContributorId() {
		return contributorId;
	}

	public void setContributorId(Long contributorId) {
		this.contributorId = contributorId;
	}

	@Column(name = "is_deleted")
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "license_id")
	public Long getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(Long licenseId) {
		this.licenseId = licenseId;
	}

	@Column(name = "object_id")
	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	@Column(name = "page_taxon_id")
	public Long getPageTaxonId() {
		return pageTaxonId;
	}

	public void setPageTaxonId(Long pageTaxonId) {
		this.pageTaxonId = pageTaxonId;
	}

	@Column(name = "trait_instance_id")
	public Long getTraitInstanceId() {
		return traitInstanceId;
	}

	public void setTraitInstanceId(Long traitInstanceId) {
		this.traitInstanceId = traitInstanceId;
	}

	@Column(name = "trait_value_id")
	public Long getTraitValueId() {
		return traitValueId;
	}

	public void setTraitValueId(Long traitValueId) {
		this.traitValueId = traitValueId;
	}

	@Column(name = "value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "object_type")
	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	@Column(name = "to_value")
	public String getToValue() {
		return toValue;
	}

	public void setToValue(String toValue) {
		this.toValue = toValue;
	}

	@Column(name = "from_date")
	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Column(name = "to_date")
	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Column(name = "data_table_id")
	public Long getDataTableId() {
		return dataTableId;
	}

	public void setDataTableId(Long dataTableId) {
		this.dataTableId = dataTableId;
	}

}
