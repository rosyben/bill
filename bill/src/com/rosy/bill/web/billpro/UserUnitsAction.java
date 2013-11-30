package com.ruanko.sdb2b.web.system;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.rosy.bill.Constants;
import com.ruanko.sdb2b.dao.Page;
import com.ruanko.sdb2b.entity.system.AppOrganization;
import com.ruanko.sdb2b.service.system.AppOrganizationManager;
import com.ruanko.sdb2b.utils.StringUtils;
import com.ruanko.sdb2b.utils.web.Struts2Utils;
import com.ruanko.sdb2b.web.CrudActionSupport;

@Namespace("/system")
@Action(value="units")
@Scope("prototype")
@Results({
	@Result(name = "operateSuccess",  location = "/dwz/operateSuccess.jsp"),
	@Result(name="list",location="/dwz/system/user_class.jsp")
})
public class UserUnitsAction extends CrudActionSupport<AppOrganization>{

	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
	HttpServletResponse response;
	public UserUnitsAction() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
	}
	
	private Page<AppOrganization> page = new Page<AppOrganization>();
	AppOrganization zation = new AppOrganization();
	public AppOrganization getModel() {
		return zation;
	}

	AppOrganizationManager manager;
	@Autowired
	public void setAppOraganizatioinManager(AppOrganizationManager manager){
		this.manager = manager;
	}
	@Override
	public String list() throws Exception {
		String orgCode = request.getParameter("orgCode");
		if(orgCode ==null || orgCode.trim().equals("")){
			orgCode = null;
		}
		String orgKind = request.getParameter("orgKind");
		if( orgKind ==null || orgKind.trim().equals("") ||orgKind.trim().equals("-1")){
			orgKind = null;
		}
		
		String orgName = request.getParameter("orgName");
		if( orgName ==null || orgName.trim().equals("")){
			orgName = null;
		}
		
		String pageNum = request.getParameter("pageNum") ;
		if (pageNum==null || pageNum.trim().equals(""))pageNum = "1";
		String size = judgePageSize();
		page.setPageNo(Integer.parseInt(pageNum));
		page.setPageSize(Integer.parseInt(size));
		page.setOrderBy("orgCode");
		page.setOrder("asc");
		manager.getAllList(page,orgCode,orgName, orgKind);
		request.setAttribute("page", page);
		request.setAttribute("orgCode", orgCode);
		request.setAttribute("orgKind", orgKind);
		request.setAttribute("orgName", orgName);
		return "list";
	}

	private String judgePageSize() {
		String size = request.getParameter("pageSize");
		if(size==null || size.trim().equals("")){
			size =""+Constants.PAGE_SIZE;
		}
		return size;
	}
	@Override
	public String input() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save() throws Exception {
		if(zation.getOid() == null){
			zation.setOid(StringUtils.genUUID());
			zation.setCreateDate(new Date());
			zation.setDelflag(Constants.DELFLAG_STR_IN);
			zation.setRecflag(Constants.RECFLAG_IN);
		}
		manager.saveApp(zation);
		request.setAttribute("forwardUrl", "dwz/system/inceptClass.jsp");
		return "operateSuccess";
	}

	@Override
	public String delete() throws Exception {
		manager.deleteByOid(request.getParameter("oid"));
		return list();
	}

	public void getByKind() {
		String kind = request.getParameter("kind");
		List<AppOrganization> list = manager.getByKind(kind);
		JSONArray array = JSONArray.fromObject(list);
		Struts2Utils.renderText(array.toString());
	}
   
	@Override
	protected void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void toMessage() {
		String pageNum = request.getParameter("pageNum") ;
		if (pageNum==null)pageNum = "1";
		String size = judgePageSize();
		page.setPageNo(Integer.parseInt(pageNum));
		page.setPageSize(Integer.parseInt(size));
		page.setOrderBy("orgCode");
		page.setOrder("asc");
		manager.getAllExtendsTime(page);
		JSONArray array = JSONArray.fromObject(page.getResult());
		Struts2Utils.renderText(array.toString());
	}
	
	public void judgeUnitsId() {
		String unitsId = request.getParameter("unitsId");
		//System.out.println(unitsId);
		AppOrganization organization = manager.getByUnitsId(unitsId);
		if(null==organization){
			Struts2Utils.renderText("isExist");
		}else{
			Struts2Utils.renderText("exist");
		}
	}
	public void toMessageForOrg(){
		String org = request.getParameter("org");
		String pageNum = request.getParameter("pageNum");
		//System.out.println(pageNum);
		if (pageNum==null||pageNum=="0")pageNum = "1";
		String size = judgePageSize();
		page.setPageNo(Integer.parseInt(pageNum));
		page.setPageSize(Integer.parseInt(size));
		page.setOrderBy("orgCode");
		page.setOrder("asc");
		manager.getAllForOrg(page,org);
		JSONArray array = JSONArray.fromObject(page.getResult());
		Struts2Utils.renderText(array.toString());
	}
	
	public void toUserForOrg(){
		String org = request.getParameter("org");
		String utype = request.getParameter("utype");
		
		List<AppOrganization> list = manager.getAllByOrg(org,utype);
		//System.out.println(list.size());
		StringBuffer sbf = new StringBuffer("");
		String result = ""; 
		if(list != null && list.size()>0){
			for(int i=0; i<list.size();i++){
				AppOrganization ao= list.get(i);
				sbf.append("{");
				sbf.append("\"id\":\"" +(ao.getOid())+"\",");
				sbf.append("\"code\":\"" +(ao.getOrgCode()==null?"":ao.getOrgCode().trim())+"\",");
				sbf.append("\"name\":\"" +(ao.getOrgName()==null?"":ao.getOrgName().trim())+"\"");
				sbf.append("},");
			}
			result = (sbf.substring(0,sbf.toString().length()-1)).toString();
		} 
		 
		Struts2Utils.renderText("["+result+"]");
 	}
}
