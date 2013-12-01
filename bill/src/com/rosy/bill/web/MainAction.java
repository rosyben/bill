/**
 * <P>MainAction.java</P> 
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
 * 2012-7-28 上午12:30:41
 */
package com.rosy.bill.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.rosy.bill.Constants;
import com.rosy.bill.dao.HibernateUtils;
import com.rosy.bill.dao.Page;
import com.rosy.bill.entity.system.Account;
import com.rosy.bill.entity.system.Role;
import com.rosy.bill.manager.system.AccountManager;
import com.rosy.bill.service.ServiceException;
import com.rosy.bill.utils.web.Struts2Utils;

/**
 * 用户管理Action.
 * 
 * 使用Struts2 convention-plugin annotation定义Action参数.
 * 演示带分页的管理界面.
 * 
 * @author calvin 
 */
//定义URL映射对应/dwz/main.action
@Namespace("/ess")

//定义名为reload的result重定向到main.action, 其他result则按照convention默认.
@Results( { 
	@Result(name = CrudActionSupport.RELOAD, location = "main.action", type = "redirect"), 
	@Result(name="success", location="/dwz/index.jsp")
	})
public class MainAction extends CrudActionSupport<Account> {

	private static final long serialVersionUID = 8683878162525847072L;

	private AccountManager accountManager;
	

	//-- 页面属性 --//
	private String id;
	private Account entity;
	private Page<Account> page = new Page<Account>(Constants.PAGE_SIZE);//每页5条记录
	private List<String> checkedRoleIds; //页面中钩选的角色id列表

	//-- ModelDriven 与 Preparable函数 --//
	public void setId(String id) {
		this.id = id;
	}

	public Account getModel() {
		entity = accountManager.getCurrentAccount();
	    Date obj = (Date) Struts2Utils.getSession().getAttribute(Constants.LAST_LOGIN_DATE);
	    if (obj != null) {
	    	//entity.setPrevLastLoginDate(obj);
	    }
	    
		return entity;
	}

	@Override
	protected void prepareModel() throws Exception {
			
		if (id != null) {
			entity = accountManager.getAccount(id);
		} else {
			entity = new Account();
		}
	}
 
	//-- CRUD Action 函数 --//
	@Override
	public String list() throws Exception {
		System.out.println("");
		//List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		//设置默认排序方式
/*		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = accountManager.searchUser(page, filters);*/
		//
		//dataMigrationService.importSundanUsers();     //导入顺电用户
		
		//dataMigrationService.importSupplierInfo();    //导入供应商
		
		//dataMigrationService.importCounterInfo();     //导入专柜用户
		
		return SUCCESS;
	}

	@Override
	public String input() throws Exception {
		checkedRoleIds = null;//entity.getRoleIds();
		return INPUT;
	}

	@Override
	public String save() throws Exception {
		//根据页面上的checkbox选择 整合User的Roles Set
		HibernateUtils.mergeByCheckedIds(entity.getRoles(), checkedRoleIds, Role.class);

		accountManager.save(entity);
		addActionMessage("保存用户成功");
		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		try {
			accountManager.deleteAccount(id);
			addActionMessage("删除用户成功");
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			addActionMessage("删除用户失败");
		}
		return RELOAD;
	}

	//-- 其他Action函数 --//
	/**
	 * 支持使用Jquery.validate Ajax检验用户名是否重复.
	 */
	public String checkLoginName() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String newLoginName = request.getParameter("loginName");
		String oldLoginName = request.getParameter("oldLoginName");

		if (accountManager.isLoginNameUnique(newLoginName, oldLoginName)) {
			Struts2Utils.renderText("true");
		} else {
			Struts2Utils.renderText("false");
		}
		//因为直接输出内容而不经过jsp,因此返回null.
		return null;
	}

	//-- 页面属性访问函数 --//
	/**
	 * list页面显示用户分页列表.
	 */
	public Page<Account> getPage() {
		return page;
	}

	/**
	 * input页面显示所有角色列表.
	 */
	public List<Role> getAllRoleList() {
		return accountManager.getAllRole();
	}

	/**
	 * input页面显示用户拥有的角色.
	 */
	public List<String> getCheckedRoleIds() {
		return checkedRoleIds;
	}

	/**
	 * input页面提交用户拥有的角色.
	 */
	public void setCheckedRoleIds(List<String> checkedRoleIds) {
		this.checkedRoleIds = checkedRoleIds;
	}

	@Autowired
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
	

}

