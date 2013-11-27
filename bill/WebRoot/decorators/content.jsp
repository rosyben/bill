<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>|<decorator:title/></title>
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/content/theme.css'/>" />
		<script type="text/javascript" src="<c:url value='/scripts/appconfig.jsp'/>"></script>	
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.js'/>" ></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.validate.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.meiomask.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.cursorMessage.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/additional.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.dimensions.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.bgiframe.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.delegate.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.tooltip.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.bgiframe.min.js'/>" ></script>
  		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.ajaxQueue.js'/>" ></script>
 	    <script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.thickbox.js'/>" ></script>
  		<script type="text/javascript" src="<c:url value='/scripts/plugin/jquery.autocomplete.js'/>" ></script>
		<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/breadcrumd.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/main.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/content/index.js'/>"></script>
        <decorator:head/>
    </head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/> >
	<div id="page" class="page">
				<!--  页面主体-->
				<div id="content" class="resize">
							<div id="breadCrumb" class="breadcrumb">
								<ul>
									<script charset="UTF-8" type="text/javascript">buildBreadCrumb();</script>
								</ul>
							</div>
							<div class="real-wrap">
								<div id="main">
								<decorator:body />
							    </div>
						   </div>
						
	              </div>
				<!-- end content -->
		</div>
		<!-- end page -->
	</body>
</html>
