package com.rosy.bill.manager.system.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rosy.bill.dao.Page;
import com.rosy.bill.dao.PropertyFilter;
import com.rosy.bill.dao.system.AccountDao;
import com.rosy.bill.dao.system.AuthorityDao;
import com.rosy.bill.dao.system.RoleDao;
import com.rosy.bill.entity.system.Account;
import com.rosy.bill.entity.system.Authority;
import com.rosy.bill.entity.system.Role;
import com.rosy.bill.manager.impl.BaseManager;
import com.rosy.bill.manager.system.AccountManager;
import com.rosy.bill.security.SpringSecurityUtils;
import com.rosy.bill.service.ServiceException;

@Component
@Transactional
public class AccountManagerImpl extends BaseManager<Account, String> implements
		AccountManager {

	private static Logger logger = LoggerFactory
			.getLogger(AccountManagerImpl.class);

	private AccountDao accountDao;
	private RoleDao roleDao;
	private AuthorityDao authorityDao;

	// -- User Manager --//
	@Transactional(readOnly = true)
	public Account getAccount(String id) {
		return accountDao.get(id);
	}

	/**
	 * 验证roleName是否重复
	 * 
	 * @param entity
	 */
	public int valRoleName(String name) {
		return roleDao.valRoleName(name);
	}

	public void saveAccount(Account entity) {
		/*
		 * if(null==entity.getId()){ String userPassWorld =
		 * com.ruanko.sdb2b.utils
		 * .StringUtils.encodePassword(Constants.USER_DEFAULT_PASSWORD,
		 * Constants.PASSWORD_ENCORDER_HASH); entity.setPassword(userPassWorld);
		 * }
		 */
		accountDao.save(entity);
	}

	/**
	 * 删除用户,如果尝试删除超级管理员将抛出异常.
	 */
	public void deleteAccount(String id) {
		if (isSupervisor(accountDao.get(id).getAccountName())) {
			logger.warn("操作员{}尝试删除超级管理员用户",
					com.rosy.bill.security.SpringSecurityUtils.getCurrentAccountName());
			throw new ServiceException("不能删除超级管理员用户");
		}
		accountDao.delete(id);
	}

	/** 
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(String id) {
		return id.equals("admin");
	}

	/**
	 * 使用属性过滤条件查询用户.
	 */
	@Transactional(readOnly = true)
	public Page<Account> searchUser(final Page<Account> page,
			final List<PropertyFilter> filters) {
		return accountDao.findPage(page, filters);
	}

	/**
	 * 使用属性过滤条件查询角色.
	 */
	@Transactional(readOnly = true)
	public Page<Role> searchRole(final Page<Role> page,
			final List<PropertyFilter> filters) {
		return roleDao.findPage(page, filters);
	}

	@Transactional(readOnly = true)
	public Page<Authority> searchAuthority(final Page<Authority> page,
			final List<PropertyFilter> filters) {
		return authorityDao.findPage(page, filters);
	}

	@Transactional(readOnly = true)
	public Account findAccountByAccountName(String accountName) {
		/*
		 * User user = new User(); user.setLoginName(userName);
		 * user.setName("管理员");
		 * org.springframework.security.authentication.encoding
		 * .ShaPasswordEncoder shaPwd = new
		 * org.springframework.security.authentication
		 * .encoding.ShaPasswordEncoder(); String pwd =
		 * shaPwd.encodePassword("admin", "SHA"); String
		 * pwd2=StringUtils.encodePassword("admin", PASSWORD_ENCORDER_HASH);
		 * user.setPassword(pwd2); user.setEmail("admin@springside.org.cn");
		 * user.setDelFlag("0"); user.setCreateDate(new
		 * java.util.Date(System.currentTimeMillis())); this.saveUser(user);
		 */
		// Role role = new Role(user.getId(),"1");
		// List<Authority> au = role.getAuthorityList();

		// List<Role> roleList = user.getRoleList();

		// roleList.add(new Role(user.getId(),"1"));
		// roleList.add(new Role(user.getId(),"2"));
		// user.setRoleList(roleList);
		// this.saveUser(user);
		// this.userDao.getSession().flush();
		return accountDao.findUniqueBy("accountName", accountName);
	}

	/**
	 * 取得当前登录用户
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Account getCurrentAccount() {
		String loginName = SpringSecurityUtils.getCurrentUserName();
		if (StringUtils.isEmpty(loginName)) {
			return null;
		}
		return this.findAccountByAccountName(loginName);
	}

	public void updateLastLoginDate(String id) {
		if (StringUtils.isEmpty(id))
			return;
		Object[] values = new Object[2];
		values[0] = new Date(System.currentTimeMillis());
		values[1] = id;
		accountDao.batchExecute("update Account set lastLoginTime=? where id=?",
				values);
	}

	/**
	 * 检查用户名是否唯一.
	 * 
	 * @return loginName在数据库中唯一或等于oldLoginName时返回true.
	 */
	@Transactional(readOnly = true)
	public boolean isLoginNameUnique(String newLoginName, String oldLoginName) {
		return accountDao
				.isPropertyUnique("accountName", newLoginName, oldLoginName);
	}

	// -- Role Manager --//
	@Transactional(readOnly = true)
	public Role getRole(String id) {
		return roleDao.get(id);
	}

	@Transactional(readOnly = true)
	public List<Role> getAllRole() {
		return roleDao.getAll("roleName", false);
	}

	public void saveRole(Role entity) {
		roleDao.save(entity);
	}

	public void deleteRole(String id) {
		roleDao.delete(id);
	}

	// -- Authority Manager --//
	@Transactional(readOnly = true)
	@Override
	public List<Authority> getAllAuthority() {
		return authorityDao.getAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Authority getAuthority(String id) {
		return authorityDao.get(id);
	}

	@Override
	public void deleteAuthority(String id) {
		authorityDao.delete(id);
	}

	@Override
	public void saveAuthority(Authority entity) {
		authorityDao.save(entity);
	}

	// 以下为注入--//

	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		//super.setDao(accountDao);
		this.accountDao = accountDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Autowired
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

}
