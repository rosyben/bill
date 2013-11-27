package com.rosy.bill.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.tool.hbm2x.StringUtils;

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
public abstract class IdEntity {

	protected String id;
	
	protected String createBy;
	
	protected Timestamp createTime; // 创建时间

	protected Short delFlag; // 删除标记

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 48, name = "id", unique = true)
	public String getId() {
//		System.out.println("============================");
		if (StringUtils.isEmpty(id)) {
			this.id = null;
			this.createTime = new Timestamp(System.currentTimeMillis());
			this.delFlag = Constants.DELFLAG_IN.shortValue();
//			System.out.println("**************************************************");
		}
		return id;
	}

	public void setId(String id) {
//		System.out.println("56565656565656565656565655");
		this.id = id;

	}

	@Column(nullable = true, updatable = false, name = "create_time")
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 创建的操作员的登录名.
	 */
	@Column(updatable = false, name = "create_by")
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(nullable = false, name = "del_flag")
	public Short getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Short delFlag) {
		this.delFlag = delFlag;
	}

}
