
	var opinionRequest=false;
	//�ж��û����Ƿ��ظ�
	
	function callbackFunc(){
		if( opinionRequest.readyState==4 ){		 //�ж���Ӧ�Ƿ���� 
     	 	if( opinionRequest.status == 200 ){  //�ж���Ӧ�Ƿ�ɹ�
         		var hasUser=opinionRequest.responseXML.getElementsByTagName("hasUser");
         		var noUser=opinionRequest.responseXML.getElementsByTagName("noUser");
         		if(typeof(hasUser)!="undefined"&& hasUser.length>0){   
         			document.getElementById("enterform").action="<%=request.getContextPath()%>"+"/UserServlet?action=enter";
	         		opinionRequest=false;
	         		document.getElementById("enterform").method="post";
	         		document.getElementById("enterform").submit();	
         		}
         		if(typeof(noUser)!="undefined"&& noUser.length>0){
	         		alert("�û������������");
	         		document.getElementById("userid").focus();
	         		opinionRequest=false;
	         		return false;
         		}
			}
		}
	}
	/**
	*��½
	*/
	
	function enter(){
		if(checkInsert()){
			var id=document.getElementById("userid").value;				//�û���
			var pwd = document.getElementById("userpwd").value;				//����
			var url="<%=request.getContextPath()%>"+"/UserServlet";			//��������ַ
			var param ="action=checkEnter&id="+id+"&pwd="+pwd;			//������� 
			opinionRequest=httpRequest("post",url,true,callbackFunc,param);	//�������󷽷� 
		}
	}
	function checkInsert(){
		var name = document.getElementById("userid").value;
		var pwd = document.getElementById("userpwd").value;
		if(name==null||name==""){
			alert("�����������˺ţ�");
			document.getElementById("userid").focus();
			return false;
		}
		if(pwd==null||pwd==""){
			alert("�������������룡");
			document.getElementById("userpwd").focus();
			return false;
		}
		if(pwd!=null&&pwd!=""){
			if(pwd.length<6||pwd.length>16){
				alert("�����������볤��Ϊ6-16λ��");
				document.getElementById("userpwd").focus();
				return false;
			}
		}
		return true;
	}
	/**
	*ע��
	*/
	function login(){
		window.location.href="login.jsp";
	}
