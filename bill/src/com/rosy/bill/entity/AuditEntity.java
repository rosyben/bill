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
public abstract class AuditEntity extends IdIntEntiy {
	
	protected Timestamp lastModifyTime; //最后修改时间
	
	protected String lastModifyBy; //最后更新者
	
	/**
	 * 最后修改时间.
	 */
	// 本属性只在update时有效,save时无效.
	@Column(insertable = false, name = "last_modify_time")
	public Timestamp getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	/**
	 * 最后修改的操作员的登录名.
	 */
	@Column(insertable = false, name = "last_modify_by")
	public String getLastModifyBy() {
		return lastModifyBy;
	}

	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}

}
