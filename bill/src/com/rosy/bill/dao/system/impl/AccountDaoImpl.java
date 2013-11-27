/**
 * <P>AccountDaoImpl.java</P> 
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
 * 2012-6-12 下午11:13:39
 */
package com.rosy.bill.dao.system.impl;

import org.springframework.stereotype.Component;

import com.rosy.bill.dao.hibernate.HibernateDao;
import com.rosy.bill.dao.system.AccountDao;
import com.rosy.bill.entity.system.Account;

/**
 * @author Ben
 *
 */
@Component 
public class AccountDaoImpl extends HibernateDao<Account, String> implements
		AccountDao {

}
