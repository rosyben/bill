package com.rosy.bill.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.rosy.bill.Constants;

/**
 * 统一定义id的entity基类.
 * 
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略. 子类可重载getId()函数重定义id的列名映射和生成策略.
 * 
 * @author Ben
 */
// JPA 基类的标识
@MappedSuperclass
public abstract class IdIntEntiy {
	
	protected Integer id;
	
	protected String createBy;
	
	protected Timestamp createTime; // 创建时间

	protected Short delFlag; // 删除标记
	
	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable=false)
	public Integer getId() {
//		System.out.println("============================");
		if (id == null) {
			this.createTime = new Timestamp(System.currentTimeMillis());
			this.delFlag = Constants.DELFLAG_IN.shortValue();
			// System.out.println("**************************************************");
		}
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the createBy
	 */
	@Column(updatable = false, name = "create_by")
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * @return the createTime
	 */
	@Column(nullable = true, updatable = false, name = "create_time")
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the delFlag
	 */
	@Column(nullable = false, name = "del_flag")
	public Short getDelFlag() {
		return delFlag;
	}

	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(Short delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
