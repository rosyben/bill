package com.rosy.bill.entity.system;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.rosy.bill.entity.AuditableEntity;

/**
 * Authority entity. @author Ben
 */
@Entity
@Table(name = "ec_authority")
public class Authority extends AuditableEntity implements Serializable {

	private static final long serialVersionUID = 7139123887413238197L;
	// Fields

	private String moduleName;
	private String moduleDescription;
	private String moduleUrl;
	private String functionName;
	private String functionDescription;
	private String functionUrl;
	
	public static final String AUTHORITY_PREFIX = "ROLE_";

	// Constructors

	/** default constructor */
	public Authority() {
	}

	// Property accessors

	@Column(name = "module_name", nullable = false, length = 30)
	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Column(name = "module_description", length = 100)
	public String getModuleDescription() {
		return this.moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	@Column(name = "module_url")
	public String getModuleUrl() {
		return this.moduleUrl;
	}

	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}

	@Column(name = "function_name", nullable = false, length = 30)
	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Column(name = "function_description", length = 100)
	public String getFunctionDescription() {
		return this.functionDescription;
	}

	public void setFunctionDescription(String functionDescription) {
		this.functionDescription = functionDescription;
	}

	@Column(name = "function_url")
	public String getFunctionUrl() {
		return this.functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}
	
	@Transient
	public String getPrefixedName() {
		return AUTHORITY_PREFIX + functionName;
	}
}