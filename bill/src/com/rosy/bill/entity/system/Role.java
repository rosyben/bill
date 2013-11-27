package com.rosy.bill.entity.system;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.google.common.collect.Lists;
import com.rosy.bill.entity.AuditableEntity;

/**
 * Role entity. @author Ben
 */
@Entity
@Table(name = "ec_Role")
public class Role extends AuditableEntity implements Serializable {

	private static final long serialVersionUID = 1279152123198344046L;
	// Fields

	private String roleName;
	private String roleDescription;

	private List<Authority> authorities = Lists.newArrayList();

	// Constructors

	/** default constructor */
	public Role() {
	}

	// Property accessors

	@Column(name = "role_name", nullable = false, length = 50)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "role_description", length = 150)
	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	// 多对多定义
	@ManyToMany
	@JoinTable(name = "ec_role_authority", joinColumns = { @JoinColumn(name = "rol_id") }, inverseJoinColumns = { @JoinColumn(name = "aut_id") })
	// Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	// 集合按id排序。
	@OrderBy("id")
	// 集合中对象id的缓存。
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	
	public List<Authority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

}