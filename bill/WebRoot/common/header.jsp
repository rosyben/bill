<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="com.rosy.bill.security.SpringSecurityUtils" %>
<%@ include file="/common/taglibs.jsp" %>
<div id="hd">
	<div id="title">
		<h1></h1>
		<h2>模型界面</h2>
	</div>
	<div id="menu">
		<ul>
			<li><a href="${ctx}/account/user.action">帐号列表</a></li>
			<li><a href="${ctx}/account/role.action">角色列表</a></li>
			<li><a href="${ctx}/j_spring_security_logout">退出登录</a></li>
		</ul>
	</div>
</div>