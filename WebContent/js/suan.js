/**
 * 
 */
$(function(){
	$("#tijiao_btn").click(function(){
		var xing=$("#xing").val()
		var ming=$("#ming").val()
		var date=$("#date").val()
		var time=$("#time").val()
		if(ming==""||xing==""||date==""||time=="")
			console.log("kong")
		else{
			$.ajax({
				url:'testv',
				data:{xing:''+xing,ming:''+ming,date:''+date,time:''+time},
				type:"POST",
				scriptCharset: 'utf-8',
				error:function(data){  
					console.log("通信错误")
		        },
		        success:function(response){  
		        	if(response!=null){
		        		console.log(response)
		        		
		        		
		        		$("#jiao").css("display","none")
		        		var jsonObj = eval( '(' + response + ')' ); 
		        		$("#xingming").html(jsonObj.ren_xing+jsonObj.ren_ming+"你的结果是：")
		        		$("#shengchen").html(jsonObj.ren_shengchen)
		        		$("#shengxiao").html(jsonObj.ren_shengxiao)
		        		$("#guzhong").html(jsonObj.ren_guzhong)
		        		$("#lunar").html(jsonObj.ren_lunar)
		        		$("#content").html(jsonObj.ren_content)
		        		$("#guo").css("display","block")
		        	}
					else
						console.log("没有返回")
		        }  
			})
		}
	})
})