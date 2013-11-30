/**
 * <P>ReceiveRecordAction.java</P> 
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
 * 2013-11-21 下午10:48:25
 */
package com.rosy.bill.web.billpro;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.rosy.bill.Constants;
import com.rosy.bill.dao.Page;
import com.rosy.bill.entity.ReceiveRecord;
import com.rosy.bill.service.billpro.CertificateService;
import com.rosy.bill.web.CrudActionSupport;

/**
 * @author Administrator
 *
 */

@Namespace("/bill")
//@Action("receiveAction")// receive_record.action
@Results({
	@Result(name="success",location="....."),//...就是页面路径，jsp路径
	@Result(name ="input", location="...")
})
public class ReceiveRecordAction extends CrudActionSupport<ReceiveRecord> {

	private static final long serialVersionUID = -3290076805559261227L;
	
	private String id;

	private ReceiveRecord receiveRecord;
	
	private ReceiveRecord condition;  
	
	private CertificateService certificateService;

	private Page<ReceiveRecord> page = new Page<ReceiveRecord>(Constants.PAGE_SIZE);


	@Override
	public ReceiveRecord getModel() {
		return receiveRecord;
	}

	@Override
	public String list() throws Exception {
		page = certificateService.findReceiveRecordPage(page, condition);
		return SUCCESS;
	}

	@Override
	public String input() throws Exception {
		return null;
	}

	@Override
	public String save() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareModel() throws Exception {
		if (!StringUtils.isEmpty(id)) {
			receiveRecord = certificateService.getReceiveRecord(id);
		} else {
			receiveRecord = new ReceiveRecord();
		}
	}
	
	
	public ReceiveRecord getReceiveRecord() {
		return receiveRecord;
	}

	public void setReceiveRecord(ReceiveRecord receiveRecord) {
		this.receiveRecord = receiveRecord;
	}

	@Autowired
	public void setCertificateService(CertificateService certificateService) {
		this.certificateService = certificateService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ReceiveRecord getCondition() {
		return condition;
	}

	public void setCondition(ReceiveRecord condition) {
		this.condition = condition;
	}

	public Page<ReceiveRecord> getPage() {
		return page;
	}

	public void setPage(Page<ReceiveRecord> page) {
		this.page = page;
	}
	
	
	

}
