/**
 * <P>RoleDao.java</P> 
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2012</p>
 *
 * <p>Company: Rosy</p>
 *
 * @author Ben
 * @version 1.0
 * 2012-6-12 下午11:14:50
 */
package com.rosy.bill.dao.system;

import com.rosy.bill.dao.Dao;
import com.rosy.bill.entity.system.Role;

/**
 * @author Ben
 *
 */
public interface RoleDao extends Dao<Role, String> {
	

	/**
	 * 重载函数,因为Role中没有建立与User的关联,因此需要以较低效率的方式进行删除User与Role的多对多中间表.
	 */
	public  void delete(String id);

	/**
	 * 验证角色名字是否重复
	 */
	public int valRoleName(String name);

}
