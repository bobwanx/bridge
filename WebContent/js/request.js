/**
 * ����XMLHttpRequest�������������
 * @param reqType���������ͣ�GET��POST��
 * @param url����������ַ
 * @param async���Ƿ��첽����
 * @param resFun����Ӧ�Ļص�����
 * @param parameter :�������
 * @return
 */

function httpRequest(reqType,url,async,resFun,parameter){
	
	var request = null;
	if( window.XMLHttpRequest ){		//��IE�����
		
		request = new XMLHttpRequest();
	}else if( window.ActiveXObject ){	//IE�����
		
		var arrSignatures = new Array("Msxml2.XMLHTTP", "Microsoft.XMLHTTP", "Microsoft.XMLHTTP", "MSXML2.XMLHTTP.5.0", "MSXML2.XMLHTTP.4.0", "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP");		
		
		for( var i = 0; i < arrSignatures.length; i++ ){
			request = new ActiveXObject( arrSignatures[i] );
			if( request || typeof( request ) == "object" )
				break;
		}
	}
	if( request || typeof( request ) == "object" ){
		request.open(reqType, url, true);	//�򿪷���������
		//��������ͷ
		request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		request.onreadystatechange = resFun;//���ô�����Ӧ�Ļص�����
		parameter = encodeURI(parameter);	//�������ַ������б���
		request.send(parameter);			//��������
		
	}
	else{
		alert( "�������֧�֣�" );
	}	
	return request;
}