package com.rosy.bill.entity.system;

import java.io.Serializable;
import java.util.Date;
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
 * Account entity. @author Ben
 */
@Entity
@Table(name = "ec_account")
public class Account extends AuditableEntity implements Serializable {

	private static final long serialVersionUID = -3951932510809349306L;
	// Fields

	private String accountType;
	private String nickname;
	private String accountName;
	private String password;
	private String email;
	private Date registerTime;
	private double balance;
	private Date lastLoginTime;
	private Integer viewNumber;
	private String userId;
	private Boolean enabled;
	
	private List<Role> roles = Lists.newArrayList();

	// Constructors

	/** default constructor */
	public Account() {
	}

	// Property accessors

	@Column(name = "account_type", length = 1)
	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Column(name = "nickname", nullable = false, length = 30)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "account_name", nullable = false, length = 30)
	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Column(name = "password", nullable = false, length = 200)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "register_time", nullable = false, length = 19)
	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "balance", precision = 22, scale = 0)
	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Column(name = "last_login_time", length = 19)
	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "view_number")
	public Integer getViewNumber() {
		return this.viewNumber;
	}

	public void setViewNumber(Integer viewNumber) {
		this.viewNumber = viewNumber;
	}

	@Column(name = "user_id", nullable = false, length = 48)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "enabled", nullable = false, length = 1)
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@ManyToMany // 多对多定义
	@JoinTable(name="ec_account_role", joinColumns = {@JoinColumn(name="acc_id")},
			inverseJoinColumns = {@JoinColumn(name="rol_id")})
	@Fetch(FetchMode.SUBSELECT) // Fecth策略定义
	@OrderBy("id") // 集合按id排序。
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE) // 集合中对象id的缓存。
	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}