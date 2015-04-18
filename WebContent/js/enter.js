
	var opinionRequest=false;
	//判断用户名是否重复
	
	function callbackFunc(){
		if( opinionRequest.readyState==4 ){		 //判断响应是否完成 
     	 	if( opinionRequest.status == 200 ){  //判断响应是否成功
         		var hasUser=opinionRequest.responseXML.getElementsByTagName("hasUser");
         		var noUser=opinionRequest.responseXML.getElementsByTagName("noUser");
         		if(typeof(hasUser)!="undefined"&& hasUser.length>0){   
         			document.getElementById("enterform").action="<%=request.getContextPath()%>"+"/UserServlet?action=enter";
	         		opinionRequest=false;
	         		document.getElementById("enterform").method="post";
	         		document.getElementById("enterform").submit();	
         		}
         		if(typeof(noUser)!="undefined"&& noUser.length>0){
	         		alert("用户名或密码错误！");
	         		document.getElementById("userid").focus();
	         		opinionRequest=false;
	         		return false;
         		}
			}
		}
	}
	/**
	*登陆
	*/
	
	function enter(){
		if(checkInsert()){
			var id=document.getElementById("userid").value;				//用户名
			var pwd = document.getElementById("userpwd").value;				//密码
			var url="<%=request.getContextPath()%>"+"/UserServlet";			//服务器地址
			var param ="action=checkEnter&id="+id+"&pwd="+pwd;			//请求参数 
			opinionRequest=httpRequest("post",url,true,callbackFunc,param);	//调用请求方法 
		}
	}
	function checkInsert(){
		var name = document.getElementById("userid").value;
		var pwd = document.getElementById("userpwd").value;
		if(name==null||name==""){
			alert("请输入您的账号！");
			document.getElementById("userid").focus();
			return false;
		}
		if(pwd==null||pwd==""){
			alert("请输入您的密码！");
			document.getElementById("userpwd").focus();
			return false;
		}
		if(pwd!=null&&pwd!=""){
			if(pwd.length<6||pwd.length>16){
				alert("输入有误，密码长度为6-16位！");
				document.getElementById("userpwd").focus();
				return false;
			}
		}
		return true;
	}
	/**
	*注册
	*/
	function login(){
		window.location.href="login.jsp";
	}
