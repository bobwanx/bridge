window.onload=function(){
	//�½���ͼ
	var map = new BMap.Map('container');  
	map.centerAndZoom(new BMap.Point(116.404,39.915), 11); 
	map.enableScrollWheelZoom();
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.ScaleControl());
	map.addControl(new BMap.OverviewMapControl());
	map.addControl(new BMap.MapTypeControl());
	map.setCurrentCity("����");
	//�����ж�λ
	$("#city_search").click(function(){
		var city=$("#city").val();
		var map = new BMap.Map('container');
		map.centerAndZoom(new BMap.Point(116.404,39.915), 12); 
		map.enableScrollWheelZoom();
		map.addControl(new BMap.NavigationControl());
		map.addControl(new BMap.ScaleControl());
		map.addControl(new BMap.OverviewMapControl());
		map.addControl(new BMap.MapTypeControl());
		map.setCenter(city);  
    }); 
	//�����궨λ
	$("#coord_search").click(function(){  
		var lng=parseFloat($("#lng").val());//��ȡֵΪString��ת��
		var lat=parseFloat($("#lat").val());
		
		var point=new BMap.Point(lng,lat);
		var map = new BMap.Map('container'); 
		
		map.centerAndZoom(point, 10); 
		map.enableScrollWheelZoom();
		map.addControl(new BMap.NavigationControl());
		map.addControl(new BMap.ScaleControl());
		map.addControl(new BMap.OverviewMapControl());
		map.addControl(new BMap.MapTypeControl());
		
		map.clearOverlays();  //ɾ��֮ǰ��ע 
		var marker = new BMap.Marker(point); //���������         
		map.addOverlay(marker); //�����ע  	      
		map.setCenter(point);//�������ĵ�ֵ��Ϊ���ĵ�   
    }); 
	//�ض�ģ����ʾ
	$("#home_nav").click(function(){  
        $("#home").css("display","block"); 
        $("#employee").css("display","none"); 
        $("#file").css("display","none"); 
        $("#reg").css("display","none"); 
        $("#login").css("display","none"); 
        $("#map").css("display","none"); 
         
    }); 
	$("#map_nav").click(function(){  
        $("#map").css("display","block"); 
        $("#employee").css("display","none"); 
        $("#file").css("display","none"); 
        $("#reg").css("display","none"); 
        $("#login").css("display","none"); 
        $("#home").css("display","none"); 
         
    }); 
	$("#employee_nav").click(function(){  
        $("#employee").css("display","block");
        $("#map").css("display","none");
        $("#file").css("display","none");
        $("#login").css("display","none");
        $("#home").css("display","none");
        $("#reg").css("display","none");
    });
	$("#file_nav").click(function(){  
        $("#file").css("display","block"); 
        $("#map").css("display","none");
        $("#employee").css("display","none");
        $("#login").css("display","none");
        $("#home").css("display","none");
        $("#reg").css("display","none");
    });
	$("#employee_login").click(function(){  
		$("#login").css("display","block"); 
        $("#file").css("display","none"); 
        $("#map").css("display","none");
        $("#employee").css("display","none");
        $("#home").css("display","none");
        $("#reg").css("display","none");
    });
	$("#employee_reg").click(function(){  
		$("#reg").css("display","block"); 
        $("#file").css("display","none"); 
        $("#map").css("display","none");
        $("#employee").css("display","none");
        $("#home").css("display","none");
        $("#login").css("display","none");
    });
	
	
}
