package com.rosy.bill.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ReceiveRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "receiveRecord")
public class ReceiveRecord extends AuditableEntity implements java.io.Serializable {

	private static final long serialVersionUID = -2715909996164933811L;

	private String batchNum;
	private String startNum;
	private String endNum;
	private String loginName;
	private String billType;
	private Date receiveDate;
	private String billStatus;



	@Column(name = "batch_num", nullable = false, length = 10)
	public String getBatchNum() {
		return this.batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	@Column(name = "start_num", nullable = false, length = 10)
	public String getStartNum() {
		return this.startNum;
	}

	public void setStartNum(String startNum) {
		this.startNum = startNum;
	}

	@Column(name = "end_num", nullable = false, length = 10)
	public String getEndNum() {
		return this.endNum;
	}

	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}

	@Column(name = "login_name", length = 20)
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "bill_type", length = 2)
	public String getBillType() {
		return this.billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	@Column(name = "receive_date", length = 23)
	public Date getReceiveDate() {
		return this.receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	@Column(name = "bill_status", length = 1)
	public String getBillStatus() {
		return this.billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

}