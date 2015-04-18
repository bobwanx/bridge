<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
	String path = request.getContextPath();    
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/bridge.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/request.js"></script>
<script type="text/javascript" src="js/enter.js"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=1.5&ak=TKhamdV6dnSRDr4ufrinOZff"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/index.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/banner.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/bottom.css" />
<title>桥梁查询系统</title>
<script>

	//登录验证
	function checkinput(){
		var name= document.getElementById("username").value;
		var pwd=document.getElementById("password").value;
		if(name==""||name==null){
			alert("用户名不能为空！");
			return false;	
		}
		if(pwd==""||pwd==null){
			alert("密码不能为空！");
			return false;
		}	
		if(name.length>10){
			alert("账号长度最大为10个字母！");
			return false;
		}
		if(pwd.length>16){
			alert("密码长度最大为16位字符！");
			return false;
		}
		return true;
	}
	//注册验证
   function isEmpty()
    {
	var l1=document.f.username.value;
	if( l1.length == 0 || l1 == null)
		{alert("用户名不能为空");return;}
			var l2=document.f.password.value;
	if( l2.length == 0 || l2 == null)
		{alert("密码不能为空");return;}
			
	var fieldvalue = document.f.age.value;
	if( fieldvalue.length == 0 || fieldvalue == null)
		{alert("年龄不能为空");return;}
	var charcode;
	var mxx="0123456789";
	for(var i=0; i<fieldvalue.length; i++){
		charcode = fieldvalue.charAt(i);
		if( (mxx.indexOf(charcode)) < 0 )
		var x=0
	}
	if (x==0){
	{alert("年龄只能是数字");return;}
	}	
   	var field = document.f.tel.value;
	if( field.length == 0 || field == null)
		alert("电话不能为空");
	var charcode;
	var mxx="0123456789";
	for(var i=0; i<field.length; i++){
		charcode = field.charAt(i);
		if( (mxx.indexOf(charcode)) < 0 )
		var y=0;
	}
	if (y==0){
	alert("电话只能是数字");
	}	
}
	
</script>

</head>
<body>
	<div id="top_menu">
		<div id="top_menu_logo">
			<img src="##" alt="logo图片">
		</div>

		<div id="top_menu_nav">
			<ul>
				<li id="home_nav">首 页</li>
				<li id="map_nav">桥梁地图</li>
				<li id="employee_nav">用户管理</li>
				<li id="file_nav">文件上传</li>
			</ul>
		</div>
	</div>

	<div id="reg">
		<form name="f" method="post" action="reg.action">
			<table width="750" height="466" border="0" cellpadding="0"
				cellspacing="0" background="picture/usermodifi.jpg">
				<tr>
					<td height="50" colspan="8">&nbsp;</td>
				</tr>
				<tr>
					<td width="43" height="22">&nbsp;</td>
					<td colspan="2"><div align="center"></div></td>
					<td colspan="2"><div align="center"></div></td>
					<td height="22" colspan="3">&nbsp;</td>
				</tr>
				<tr>
					<td height="31" colspan="8">&nbsp;</td>
				</tr>
				<tr>
					<td height="28">&nbsp;</td>
					<td height="28">&nbsp;</td>
					<td height="28" colspan="5"><div align="center">员工信息注册</div></td>
					<td height="28">&nbsp;</td>
				</tr>
				<tr>
					<td height="32">&nbsp;</td>
					<td height="32">&nbsp;</td>
					<td height="32" colspan="2"><div align="center">姓名：</div></td>
					<td height="32" colspan="3"><input id="username" type="text"
						name="username"></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="29">&nbsp;</td>
					<td height="29">&nbsp;</td>
					<td height="29" colspan="2"><div align="center">密码：</div></td>
					<td height="29" colspan="3"><input id="password"
						type="password" name="password"></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="32">&nbsp;</td>
					<td height="32">&nbsp;</td>
					<td height="32" colspan="2"><div align="center">性别：</div></td>
					<td height="32" colspan="1"><input type="radio" name="sex"
						value="男">男</td>
					<td height="32" colspan="1"><input type="radio" name="sex"
						value="女">女</td>

				</tr>
				<tr>
					<td height="35">&nbsp;</td>
					<td height="35">&nbsp;</td>
					<td height="35" colspan="2"><div align="center">年龄：</div></td>
					<td height="35" colspan="3"><input id="age" type="text"
						name="age"></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="25">&nbsp;</td>
					<td height="25">&nbsp;</td>
					<td height="25" colspan="2"><div align="center">电话：</div></td>
					<td height="25" colspan="3"><input id="tel" type="text"
						name="tel"></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="25">&nbsp;</td>
					<td height="25">&nbsp;</td>
					<td height="25" colspan="2"><div align="center">部门：</div></td>
					<td height="25" colspan="3"><input id="sector" type="text"
						name="sector"></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="25">&nbsp;</td>
					<td height="25">&nbsp;</td>
					<td height="25" colspan="2"><div align="center">职务：</div></td>
					<td height="25" colspan="3"><input id="duty" type="text"
						name="duty"></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td height="36">&nbsp;</td>
					<td height="36">&nbsp;</td>
					<td height="36" colspan="2"><div align="center"></div></td>
					<td width="49" height="36">&nbsp;</td>
					<td width="105"><div align="right">
							<input type="submit" name="Submit2" value="注册"
								onMouseUp="isEmpty()"> <input type="reset" name="Submit"
								value="重置">
						</div></td>
					<td width="126">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</form>
	</div>

	<div id="login">
		<form id="userform" method="post" action="login.action">
			<h4 align="center">员工登录</h4>
			<table width="133" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="80"><font size="2px">账&nbsp;&nbsp;号：</font></td>
					<td width="76"><input name="loginname" id="loginname"
						type="text" size="10" /></td>
				</tr>
				<tr>
					<td><font size="2px">密&nbsp;&nbsp;码：</font></td>
					<td><input name="loginpwd" id="loginpwd" type="password"
						size="10"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="登录" /></td>
				</tr>
			</table>
		</form>

	</div>

	<div id="home" > <% if (session.getAttribute("loginname")==null) out.print("");else out.print(session.getAttribute("loginname")+","); %>欢迎登陆系统！
	
	</div>

	<div id="map">
		<div id="map_serch">
			城市：<input type="text" id="city" name="city" size="5"> <input
				type="button" value="定位" id="city_search"> 经度：<input
				type="text" name="lng" id="lng" size="8" /> 维度：<input type="text"
				name="lat" id="lat" size="8" /> <input type="button" value="坐标查询"
				id="coord_search">
		</div>

		<div id="map_mange">
			<div id="map_result"></div>
			<div id="container"></div>
		</div>
	</div>


	<div id="employee">
		<div id="employee_info" style="display:<% if(session.getAttribute("loginname")==null) out.print("none"); else out.print("block"); %>">
			<a href="QuerySelf.action?id=${id}">查看个人信息</a>
			<br/>
			<a  href="QueryEmployee.action">查看员工信息</a>
			<br/>
			<a  href="logoff.jsp">注销</a>
		</div>
		<div style="display:<% if(session.getAttribute("loginname")==null) out.print("block"); else out.print("none"); %>">
			<img src="css/images/login.png" id="employee_login"><br />
			<img src="css/images/reg.png" id="employee_reg">

		</div>
		<div id=employee_self>	
		
		
		</div>	
		
		<div id="employee_dis" style="display: <% if(session.getAttribute("query")==null) out.print("none");else out.print("block");%>">
			<table>
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th align="center">性别</th>
					<th>年龄</th>
					<th>手机号</th>
					<th>部门</th>
					<th>职务</th>
				</tr>
				<c:forEach items="${userlist}" var="list">
					<tr>
						<td align="center">${list.id}</td>
						<td>${list.username}</td>
						<td>${list.sex}</td>
						<td>${list.age}</td>
						<td>${list.tel}</td>
						<td>${list.sector}</td>
						<td>${list.duty}</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
		
	</div>
	
	

	<div id="file">
		<div id="file_type">上传文件：</div>
		<div id="file_upload">
			<form action="fileUploadAction" method="POST"
				enctype="multipart/form-data">
				<table>
					<tr>
						<td><input type="file" name="myFile" /></td>
					</tr>
					<tr>
						<td><input type="file" name="myFile" /></td>
					</tr>
					<tr>
						<td><input type="file" name="myFile" /></td>
					</tr>
					<tr>
						<td align="center"><input type="submit" value="上传文件" /></td>
					</tr>
				</table>

			</form>
		</div>
	</div>



</body>
</html>