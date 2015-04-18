window.onload=function(){
	//新建地图
	var map = new BMap.Map('container');  
	map.centerAndZoom(new BMap.Point(116.404,39.915), 11); 
	map.enableScrollWheelZoom();
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.ScaleControl());
	map.addControl(new BMap.OverviewMapControl());
	map.addControl(new BMap.MapTypeControl());
	map.setCurrentCity("北京");
	//按城市定位
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
	//按坐标定位
	$("#coord_search").click(function(){  
		var lng=parseFloat($("#lng").val());//获取值为String需转换
		var lat=parseFloat($("#lat").val());
		
		var point=new BMap.Point(lng,lat);
		var map = new BMap.Map('container'); 
		
		map.centerAndZoom(point, 10); 
		map.enableScrollWheelZoom();
		map.addControl(new BMap.NavigationControl());
		map.addControl(new BMap.ScaleControl());
		map.addControl(new BMap.OverviewMapControl());
		map.addControl(new BMap.MapTypeControl());
		
		map.clearOverlays();  //删掉之前标注 
		var marker = new BMap.Marker(point); //创立坐标点         
		map.addOverlay(marker); //加入标注  	      
		map.setCenter(point);//将传来的点值设为中心点   
    }); 
	//特定模板显示
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
