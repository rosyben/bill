/**
 * <P>ReceiveRecordDao.java</P> 
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
 * 2013-11-20 下午10:01:29
 */
package com.rosy.bill.dao.billpro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rosy.bill.dao.Dao;
import com.rosy.bill.dao.hibernate.HibernateDao;
import com.rosy.bill.entity.ReceiveRecord;

/**
 * @author cgy
 *
 */
@Component
public class ReceiveRecordDao extends HibernateDao<ReceiveRecord, String>
		implements Dao<ReceiveRecord, String> {
	private Logger loger = LoggerFactory.getLogger(ReceiveRecordDao.class);

}
