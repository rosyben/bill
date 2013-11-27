/**
 * <P>CodeDaoImpl.java</P> 
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
 * 2012-6-12 下午11:35:41
 */
package com.rosy.bill.dao.system.impl;

import org.springframework.stereotype.Component;

import com.rosy.bill.dao.hibernate.HibernateDao;
import com.rosy.bill.dao.system.CodeDao;
import com.rosy.bill.entity.system.Code;

/**
 * @author Ben
 *
 */
@Component
public class CodeDaoImpl extends HibernateDao<Code, String> implements CodeDao {

}
