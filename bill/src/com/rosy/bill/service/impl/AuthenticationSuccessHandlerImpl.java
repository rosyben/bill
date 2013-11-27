/**
 * 
 */
package com.rosy.bill.service.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.rosy.bill.Constants;
import com.rosy.bill.entity.system.Account;
import com.rosy.bill.manager.system.AccountManager;

/**
 * 认证成功后的处理
 * 权限登录成功句柄 
 * 该类为平台成功跳转到多个入口提供依据 
 * @author Ben
 *
 */
public class AuthenticationSuccessHandlerImpl extends
		SimpleUrlAuthenticationSuccessHandler {
	
    /** 
     * url参数 
     */  
	private Map<String, String> map; 
	
    /** 
     * 多role选择,默认取得权限表第一个权限 
     */  
    private boolean isFirst = true; 
    
    private AccountManager accountManager;

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		//doing
		//authentication.getDetails();
		//((Authentication) authentication.getPrincipal()).getName();
		Account currentAccount = accountManager.getCurrentAccount();
		
		HttpSession session = request.getSession(true);
		Object obj = session.getAttribute(Constants.LAST_LOGIN_DATE);
		if (obj != null) {
			session.removeAttribute(Constants.LAST_LOGIN_DATE);
		}
		session.setAttribute(Constants.LAST_LOGIN_DATE, currentAccount.getLastLoginTime());
		
		accountManager.updateLastLoginDate(currentAccount.getId());

		super.onAuthenticationSuccess(request, response, authentication);//AuthenticationSuccess(request, response, auth);
		
		//super.onAuthenticationSuccess(request, response, authentication);
		/*
        Assert.notNull(map, "AuthInterceptMap is null!");  
        String url = "";  
        Collection<GrantedAuthority> authCollection = authentication.getAuthorities();  
        
        if (authCollection.isEmpty()) {  
            return;  
        }  
        //对于一个登录用户有多种角色,只取得第一个  
        if (isFirst) {  
            GrantedAuthority[] a = new GrantedAuthorityImpl[]{};  
            url = map.get(authCollection.toArray(a)[0].toString());  
            response.sendRedirect(request.getContextPath() + url);  
            return;  
        }  
        //选择取得最后一个role掉转;这里一个用户的多个角色较少  
        //迭代的速度比转换成数组的速度要快  
        for (GrantedAuthority auth : authCollection) {  
            url = map.get(auth.getAuthority());  
        }  
        response.sendRedirect(url);  */
    }  
	
    /** 
     * 权限跳转依据 
     * @param map 参数 
     *  key:url 
     *  value:role 
     */  
    public void setAuthDispatcherMap(Map<String, String> map) {  
        this.map = map;  
    }  
  
    /** 
     * 多种角色方案 
     * 设置是否只取得第一个role 
     * @param isFirst true:多种角色只取第一个，false:取得最后一个 
     */  
    public void setMultipleAuth(boolean isFirst) {  
        this.isFirst = isFirst;  
    }

	/**
	 * @param accountManager the accountManager to set
	 */
    @Autowired
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}  

}


