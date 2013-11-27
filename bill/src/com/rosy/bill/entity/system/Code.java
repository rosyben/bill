package com.rosy.bill.entity.system;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rosy.bill.entity.AuditableEntity;

/**
 * Code entity. @author Ben
 */
@Entity
@Table(name = "ec_code")
public class Code extends AuditableEntity implements Serializable {

	private static final long serialVersionUID = 3314842608667962448L;
	
	// Fields
	
	private String typeName;
	private Integer typeCode;
	private String name;
	private String code;
	private String hasChildren;
	private Integer childType;
	private String remark;
	private String useFlag;

	// Constructors

	/** default constructor */
	public Code() {
	}

	// Property accessors

	@Column(name = "type_name", nullable = false, length = 50)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "type_code", nullable = false)
	public Integer getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(Integer typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code", nullable = false, length = 4)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "has_children", nullable = false, length = 1)
	public String getHasChildren() {
		return this.hasChildren;
	}

	public void setHasChildren(String hasChildren) {
		this.hasChildren = hasChildren;
	}

	@Column(name = "child_type")
	public Integer getChildType() {
		return this.childType;
	}

	public void setChildType(Integer childType) {
		this.childType = childType;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "use_flag", nullable = false, length = 1)
	public String getUseFlag() {
		return this.useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}

}