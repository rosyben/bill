/**
 * <P>AccountManagers.java</P> 
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
 * 2012-6-12 下午11:41:03
 */
package com.rosy.bill.manager.system;

import java.util.List;

import com.rosy.bill.dao.Page;
import com.rosy.bill.dao.PropertyFilter;
import com.rosy.bill.entity.system.Account;
import com.rosy.bill.entity.system.Authority;
import com.rosy.bill.entity.system.Role;
import com.rosy.bill.manager.Manager;

/**
 * @author Ben 
 *
 */
public interface AccountManager extends Manager<Account, String> {
	

	public Account getAccount(String id);
	
	/**
	 * 验证roleName是否重复
	 * @param entity
	 */
	public int valRoleName(String name);
	
	public void saveAccount(Account entity);

	/**
	 * 删除用户,如果尝试删除超级管理员将抛出异常.
	 */
	public void deleteAccount(String id);

	/**
	 * 使用属性过滤条件查询用户.
	 */
	public Page<Account> searchUser(final Page<Account> page, final List<PropertyFilter> filters);
	
	/**
	 * 使用属性过滤条件查询角色.
	 */
	public Page<Role> searchRole(final Page<Role> page, final List<PropertyFilter> filters);
	
	public Page<Authority> searchAuthority(final Page<Authority> page, final List<PropertyFilter> filters);
	

	public Account findAccountByAccountName(String accountName);
	
	/**
	 * 取得当前登录账户
	 * @return
	 */
	public Account getCurrentAccount();
	
	public void updateLastLoginDate(String id);
	
	/**
	 * 检查用户名是否唯一.
	 *
	 * @return loginName在数据库中唯一或等于oldLoginName时返回true.
	 */
	public boolean isLoginNameUnique(String newLoginName, String oldLoginName);

	//-- Role Manager --//

	public Role getRole(String id);
	
	public List<Role> getAllRole();

	public void saveRole(Role entity);

	public void deleteRole(String id);
	
	
	
	//-- Authority Manager --//
	public List<Authority> getAllAuthority();
	
	public void saveAuthority(Authority entity);

	public Authority getAuthority(String id);
	
	public void deleteAuthority(String id );
	
	

	
	
	

}
