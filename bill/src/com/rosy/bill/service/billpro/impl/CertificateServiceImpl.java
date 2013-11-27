/**
 * <P>CertificateServiceImpl.java</P> 
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
 * 2013-11-20 下午10:25:38
 */
package com.rosy.bill.service.billpro.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosy.bill.dao.Page;
import com.rosy.bill.entity.ReceiveRecord;
import com.rosy.bill.manager.billpro.ReceiveRecordManager;
import com.rosy.bill.service.ServiceException;
import com.rosy.bill.service.billpro.CertificateService;

/**
 * @author cgy
 *
 */
@Service
public class CertificateServiceImpl implements CertificateService {
	private Logger logger = LoggerFactory.getLogger(CertificateServiceImpl.class);
	private ReceiveRecordManager receiveRecordManager; //领用记录组件接口

	@Autowired
	public void setReceiveRecordManager(ReceiveRecordManager receiveRecordManager) {
		this.receiveRecordManager = receiveRecordManager;
	}


	/* (non-Javadoc)
	 * @see com.rosy.bill.service.billpro.CertificateService#findReceiveRecordPage(com.rosy.bill.dao.Page, com.rosy.bill.entity.ReceiveRecord)
	 */
	@Override
	public Page<ReceiveRecord> findReceiveRecordPage(Page<ReceiveRecord> page,
			ReceiveRecord condition) {
		try {
			return receiveRecordManager.findPageBy(page, condition);
		} catch (ServiceException e) {
			logger.error("");
			e.printStackTrace();
			return null;
		}
	
	}


	/* (non-Javadoc)
	 * @see com.rosy.bill.service.billpro.CertificateService#saveReceiveRecord(com.rosy.bill.entity.ReceiveRecord)
	 */
	@Override
	public void saveReceiveRecord(ReceiveRecord receiveRecord) {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see com.rosy.bill.service.billpro.CertificateService#deleteReceiveRecord(java.lang.String)
	 */
	@Override
	public void deleteReceiveRecord(String id) {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see com.rosy.bill.service.billpro.CertificateService#getReceiveRecord(java.lang.String)
	 */
	@Override
	public ReceiveRecord getReceiveRecord(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
