<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title><fmt:message key="webapp.name"/>-<decorator:title/></title>
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/content/theme.css'/>" />
		<script type="text/javascript" src="<c:url value='/scripts/appconfig.jsp'/>"></script>	
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.js'/>" ></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.validate.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.meiomask.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.cursorMessage.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/additional.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.dimensions.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.delegate.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.tooltip.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.bgiframe.min.js'/>" ></script>
  		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.ajaxQueue.js'/>" ></script>
  		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.autocomplete.js'/>" ></script>
		<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/breadcrumd.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/main.js'/>"></script>
        <style type="text/css">
body {
	background: white;
	margin: 5px;
}
</style>
        <decorator:head/>
    </head> <decorator:body/>
</html>
