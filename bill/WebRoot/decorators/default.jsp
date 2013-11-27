<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title><s:text name="webapp.name"/>-<decorator:title/></title>
		<link href="${ctx}/styles/yui.css" type="text/css" rel="stylesheet"/>
		<link href="${ctx}/styles/style.css" type="text/css" rel="stylesheet"/>
		<script src="${ctx}/scripts/jquery.js" type="text/javascript"></script>
		<script src="${ctx}/scripts/plugin/validate/jquery.validate.js" type="text/javascript"></script>
		<script src="${ctx}/scripts/plugin/validate/messages_cn.js" type="text/javascript"></script>
        <decorator:head/>
    </head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/> >

    <div id="page"> 
        <div id="header" class="clearfix" align="center">
            <jsp:include page="/common/header.jsp"/>
                <div id="nav" class="clearfix">
               <div class="real-wrap">
                </div>
                </div>
              <!-- end nav -->
        </div>
       
        	<!-- secondary  navigation begin-->
        <div class="breadcrumb clearfix">
			   <div class="real-wrap">
				 </div>
				 <div class="rightbreadcrumb"><span>
				 &nbsp;&nbsp;&nbsp;
           <c:if test="${pageContext.request.remoteUser != null}">
           <s:text name="user.status"/><security:authentication property="principal.username"/>
          </c:if></span><span class="login"></span>
			</div>
			</div>
			
		    <!-- secondary  navigation end-->
		    <!--  main content begin-->
        <div id="content" class="clearfix" align="center" >
			 <div class="real-wrap clearfix">
            <!-- left navigation begin -->
            <c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>
            <c:set var="currentItem" scope="request"><decorator:getProperty property="meta.item"/></c:set>
			  <!-- left navigation end -->
			              <div id="main">
                <h1><decorator:getProperty property="page.heading"/></h1>
                <decorator:body/>
            </div> 
		    </div>
		     <!-- end real-wrap -->
        </div>
        <!-- end content -->
        <div id="footer" class="clearfix">
            <jsp:include page="/common/footer.jsp"/>
        </div>
    </div>
    
</body>
</html>
