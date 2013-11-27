/**
 * <P>AppendixDaoImpl.java</P> 
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
 * 2012-6-12 下午11:37:08
 */
package com.rosy.bill.dao.system.impl;

import org.springframework.stereotype.Component;

import com.rosy.bill.dao.hibernate.HibernateDao;
import com.rosy.bill.dao.system.AppendixDao;
import com.rosy.bill.entity.system.Appendix;

/**
 * @author Ben
 *
 */
@Component
public class AppendixDaoImpl extends HibernateDao<Appendix, String> implements
		AppendixDao {

}
