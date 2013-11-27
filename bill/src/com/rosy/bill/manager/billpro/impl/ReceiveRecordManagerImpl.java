/**
 * <P>ReceiveRecordManagerImpl.java</P> 
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
 * 2013-11-20 下午10:11:25
 */
package com.rosy.bill.manager.billpro.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rosy.bill.dao.Page;
import com.rosy.bill.dao.billpro.ReceiveRecordDao;
import com.rosy.bill.entity.ReceiveRecord;
import com.rosy.bill.manager.billpro.ReceiveRecordManager;
import com.rosy.bill.manager.impl.BaseManager;

/**
 * @author cgy
 *
 */
@Component
@Transactional
public class ReceiveRecordManagerImpl extends
		BaseManager<ReceiveRecord, String> implements ReceiveRecordManager {
	private Logger loger = LoggerFactory.getLogger(ReceiveRecordManagerImpl.class);
	
	/**
	 *  领用记录Dao
	 */
	private ReceiveRecordDao receiveRecordDao;

	@Autowired
	public void setReceiveRecordDao(ReceiveRecordDao receiveRecordDao) {
		super.setDao(receiveRecordDao);
		this.receiveRecordDao = receiveRecordDao;
	}

	/* (non-Javadoc)
	 * @see com.rosy.bill.manager.impl.BaseManager#findPageBy(com.rosy.bill.dao.Page, java.lang.Object)
	 */
	@Override
	public Page<ReceiveRecord> findPageBy(Page<ReceiveRecord> page,
			ReceiveRecord condition) {
		// TODO Auto-generated method stub
		return super.findPageBy(page, condition);
	}

	/* (non-Javadoc)
	 * @see com.rosy.bill.manager.impl.BaseManager#logicDelete(java.lang.String[])
	 */
	@Override
	public void logicDelete(String... ids) {
		// TODO Auto-generated method stub
		super.logicDelete(ids);
	}

	
	

}
