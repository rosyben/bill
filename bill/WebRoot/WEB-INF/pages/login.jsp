<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter" %>
<%@ page import="org.springframework.security.web.WebAttributes" %>
<%@ page import="com.rosy.bill.Constants" %>
<% String help_path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>顺电电子商务-B2B系统登录</title>
<%@ include file="/common/meta.jsp" %>
<link rel="shortcut icon" href="${ctx}/favicon.ico" type="image/x-icon"/>
<link rel="bookmark" href="${ctx}/favicon.ico"  type="image/x-icon"/>
<link href="${ctx}/dwz/themes/css/login.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/dwz/javascripts/jquery-1.4.4.js" type="text/javascript"></script>
<style type="text/css">
.login_inner li a{ color:#DA4901; text-decoration:none; cursor:pointer;}
.login_inner li a:hover { text-decoration:underline;}
</style>

<script type="text/javascript">
//var i = 0;
//var count = 0; //本页有多少条
var pages = 0; //总页数
var currentPage = 1; //当前页数
var timeId;
  $(document).ready(function() {
	  $("#j_username").focus();
	  addLi(1);
  }); 
function addLi(pageNum){
	var url = "${ctx}/dwz/system/broadcast!getBroadcastList.action?pageNum="+pageNum;
	$.ajax({
		type : 'POST',
		url : url,
		cache : false,
		success : function (res) {
		  json = eval(res)
		  var guangao=[];
		  for(var i=0; i<json.length-1; i++) {
		  	guangao.push("<li><a onmouseover='stop()' onmouseout='start()' href='dwz/system/broadcast!broadcastDetail.action?broadcast_oid="+json[i].oid+"' target='_blank'>"
		  			+json[i].title+"      ["+(json[i].releaseDate.month+1)+"-"+json[i].releaseDate.date+"]</a></li>");
		  }
		  $('#dvmq').hide();
		  $("#guangao").append(guangao.join(""));
		  $('#dvmq').fadeIn('fast');
		//  count = json.length-1;
		  pages = json[json.length-1];
		  timeId = setInterval('refresh()',5000);
		}
	})
}

function refresh(){
	$('#dvmq').fadeOut('slow');
	$('#dvmq li').remove();
	clearInterval(timeId);
	currentPage++;
	if(currentPage > pages)
		currentPage = 1;
	addLi(currentPage);
}

//轮换显示广播（已不使用）
function scroll_news(){
      $('#dvmq li').eq(0).fadeOut('slow',function(){        
    	  $(this).clone().appendTo($(this).parent()).fadeIn('slow');
          $(this).remove();
        });
      count--;
      if(count < 0){
    	  $('#dvmq li').remove();
  		clearInterval(timeId);
  		currentPage++;
  		if(currentPage > pages)
  			currentPage = 1;
  		addLi(currentPage);
      }
	}

function stop(){
	clearInterval(timeId);
}

function start(){
	timeId = setInterval('refresh()',5000);
}
</script>

</head>
<body> 
<div id="login">
  <div id="login_header">
    <h1 class="login_logo"> <a href="#"><img src="${ctx}/dwz/themes/default/images/login_logo.gif" /></a> </h1>
    <div class="login_headerContent">
      <div class="navList">
        <ul>
          <li><a href="#">设为首页</a></li>
          <li><a href="<%=help_path%>/b2b_help/index.htm">B2B系统供应商使用手册</a></li>
        </ul>
      </div>
      <h2 class="login_title"><img src="${ctx}/dwz/themes/default/images/login_title.png" /></h2>
    </div>
  </div>
  <div id="login_content">
    <div class="loginForm">
    <%
	if (session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION) != null) {
	%> 
	<div class="error"> 登录失败，请重试。</div> 
	<%
	}
   %>
      <form id="loginForm" action="${ctx}/j_spring_security_check" method="post">
        <p>
          <label>用户名：</label>
          <input type='text' id='j_username' name='j_username' size="20" class="login_input" 
            <s:if test="not empty param.error">
		      value='<%=session.getAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY)%>'</s:if> />
        </p>
        <p>
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type='password' id='j_password' name='j_password' size="20" class="login_input" />
        </p>
        <div class="login_bar">
          <input class="sub" type="submit" value="" />
          <a href="" class="forgot">忘记密码</a> </div> 
      </form>
    </div>
    <div class="login_banner"><img src="${ctx}/dwz/themes/default/images/login_banner.jpg" /></div>
    <div class="login_main">
      <ul class="helpList">
        <li><a href="http://210.75.21.125/b2b/info/intro.htm">公司简介</a></li>
        <li><a href="http://210.75.21.125/b2b/info/structure.htm">公司部门架构</a></li>
        <li><a href="http://www.sundan.com/b2b/daobaoshu.doc">促销担保书</a></li>
      </ul>
      <div  class="login_inner" id="dvmq">
      <ul id="guangao">
      </ul>
    </div>
  </div>
  <div id="login_footer"><span  style="float:right; margin-right: 5px">© 2011 深圳市顺电连锁股份有限公司 版权所有&nbsp;&nbsp;&nbsp;技术支持：<a href="http://www.broadengate.com"  target="_blank">深圳市易思博信息技术有限公司</a></span> </div>
</div>
</div>
</body>
</html>