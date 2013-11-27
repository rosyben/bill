  <%@ page language="java" pageEncoding="UTF-8"%>
 <%@ include file="/common/taglibs.jsp" %>
    <div id="divider"></div><div></div>
    <span class="left">版本 1.0.0
        <span id="validators">        
        </span>
        <c:if test="${pageContext.request.remoteUser != null}">
        | <fmt:message key="user.status"/> <authz:authentication  operation="fullName"/>
        | 所在单位: <authz:authentication  operation="orgName"/>
        </c:if>
    </span>
    <span  style="float:right; margin-right: 5px">
    	监制：深圳市顺电电子商务&nbsp;&nbsp;&nbsp; 技术支持: <a href="http://www.broadengate.com"  target="_blank">深圳市易思博软件信息技术有限公司</a>
    </span>
 
