<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title><fmt:message key="webapp.name"/>-<decorator:title/></title>
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/content/theme.css'/>" />
		<script type="text/javascript" src="<c:url value='/scripts/appconfig.jsp'/>"></script>	
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.js'/>" ></script>
		<script type="text/javascript" src="<c:url value='/scripts/global.js'/>" ></script>
		<script type="text/javascript" src="<c:url value='/scripts/index.js'/>"></script>
        <decorator:head/>
    </head> <decorator:body/>
</html>
