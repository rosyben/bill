/**
 * <P>RoleDaoImpl.java</P> 
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
 * 2012-6-12 下午11:15:38
 */
package com.rosy.bill.dao.system.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.rosy.bill.dao.hibernate.HibernateDao;
import com.rosy.bill.dao.system.RoleDao;
import com.rosy.bill.entity.system.Account;
import com.rosy.bill.entity.system.Role;

/**
 * @author Ben
 *
 */
@Component 
public class RoleDaoImpl extends HibernateDao<Role, String> implements RoleDao {

	private static final String QUERY_ACCOUINT_BY_ROLEID = "select u from Account u left join u.roles r where r.id=?";

	/* (non-Javadoc)
	 * @see com.rosy.bill.dao.system.impl.RoleDao#delete(java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void delete(String id) {
		Role role = get(id);
		//查询出拥有该角色的用户,并删除该用户的角色.
		List<Account> accounts = createQuery(QUERY_ACCOUINT_BY_ROLEID, role.getId()).list();
		for (Account u : accounts) {
			u.getRoles().remove(role);
		}
		super.delete(role);
	}
	/* (non-Javadoc)
	 * @see com.rosy.bill.dao.system.impl.RoleDao#valRoleName(java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int valRoleName(String name ){
		String sql = "from Role where 1=1 and roleName =? ";
		Query query = getSession().createQuery(sql);
		query.setString(0, name);	
		List<Role> role = query.list();
		return role.size();
	}
	
}
