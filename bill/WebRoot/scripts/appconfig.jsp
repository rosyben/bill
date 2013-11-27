<%@ page language="java" contentType="text/javascript" pageEncoding="UTF-8"%>
/**
* 全局变量设置
*/
var appConfig ={
	appName:'<%=application.getServletContextName()%>',
	contPath:'/<%=application.getServletContextName()%>',
	systemUrl: function (){
	  return  "http://"+window.location.hostname+":"+window.location.port+"/"+this.appName+"/";
	}
};

