package com.rosy.bill.entity.system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rosy.bill.entity.AuditableEntity;

/**
 * Appendix entity. @author Ben
 */
@Entity
@Table(name = "ec_appendix")
public class Appendix extends AuditableEntity implements Serializable {
	
	private static final long serialVersionUID = -5088628783124073431L;
	
	// Fields
	
	private String owner;
	private String ownerKey;
	private String appendixType;
	private String url;
	private String author;
	private Date uploadTime;

	// Constructors

	/** default constructor */
	public Appendix() {
	}

	// Property accessors
	
	@Column(name = "owner", nullable = false, length = 150)
	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Column(name = "owner_key", nullable = false, length = 100)
	public String getOwnerKey() {
		return this.ownerKey;
	}

	public void setOwnerKey(String ownerKey) {
		this.ownerKey = ownerKey;
	}

	@Column(name = "appendix_type", nullable = false, length = 10)
	public String getAppendixType() {
		return this.appendixType;
	}

	public void setAppendixType(String appendixType) {
		this.appendixType = appendixType;
	}

	@Column(name = "url", nullable = false)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "author", length = 50)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "upload_time", length = 19)
	public Date getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

}