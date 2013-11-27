package com.rosy.bill.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 含审计信息的Entity基类.
 * 
 * @author Ben
 */
@MappedSuperclass
public class AuditableEntity extends IdEntity {

	protected Timestamp lastUpdateTime;
	protected String lastUpdateBy;

	/**
	 * 最后修改时间.
	 */
	// 本属性只在update时有效,save时无效.
	@Column(insertable = false, name = "last_update_time")
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		if (lastUpdateTime == null) {
			lastUpdateTime = new Timestamp(System.currentTimeMillis());
		}
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * 最后修改的操作员的登录名.
	 */
	@Column(insertable = false, name = "last_update_by")
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

}
