package com.rosy.bill.dao.hibernate;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.SaveOrUpdateEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rosy.bill.entity.AuditableEntity;
import com.rosy.bill.security.SpringSecurityUtils;

/**
 * 在自动为entity添加审计信息的Hibernate EventListener.
 * 
 * 在hibernate执行saveOrUpdate()时,自动为AuditableEntity的子类添加审计信息.
 * 
 * @author Ben
 */
public class AuditListener implements SaveOrUpdateEventListener {

	private static final long serialVersionUID = -7481545873785342485L;
	private static Logger logger = LoggerFactory.getLogger(AuditListener.class);

	public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
		Object object = event.getObject();

		//如果对象是AuditableEntity子类,添加审计信息.
		if (object instanceof AuditableEntity) {
			AuditableEntity entity = (AuditableEntity) object;
			String loginName = SpringSecurityUtils.getCurrentUserName();

			if (entity.getId() == null) {
				//创建新对象
				entity.setCreateTime(new Timestamp(System.currentTimeMillis()));
				entity.setCreateBy(loginName);
			} else {
				//修改旧对象
				entity.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
				entity.setLastUpdateBy(loginName);

				logger.info("{}对象(ID:{}) 被 {} 在 {} 修改", new Object[] { event.getEntityName(), entity.getId(),
						loginName, new Date() });
			}
		}
	}
}
