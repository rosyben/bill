/**
 * <P>CertificateService.java</P> 
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
 * 2013-11-20 下午10:24:31
 */
package com.rosy.bill.service.billpro;

import com.rosy.bill.dao.Page;
import com.rosy.bill.entity.ReceiveRecord;

/**
 * @author cgy
 * 
 */
public interface CertificateService {

	public Page<ReceiveRecord> findReceiveRecordPage(Page<ReceiveRecord> page,
			ReceiveRecord condition);
	
	public void saveReceiveRecord(ReceiveRecord receiveRecord);
	
	public void deleteReceiveRecord(String id);
	
	public ReceiveRecord getReceiveRecord(String id);

}
