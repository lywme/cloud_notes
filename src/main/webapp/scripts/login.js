function userLogin(){
	var username=$("#count").val().trim();
	var pwd=$("#password").val().trim();
	var ok=true;
	
	$("#count_span").html("");
	$("#pwd_span").html("");
	
	if(username=="")
	{
		$("#count_span").html("用户名不能为空");
		ok=false;
	}
	if(pwd=="")
	{
		$("#pwd_span").html("密码不能为空");
		ok=false;
	}
	
	//发送请求
	if(ok)
	{
		$.ajax({
			url:path+"/user/login.do",
			type:"post",
			data:{"name":username,"password":pwd},
			dataType:"json",
			success:function(result){
				if(result.status==0)
				{
					//登录成功，用户名保存到cookie当中
					var userId=result.data.cn_user_id;
					var userNick=result.data.cn_user_nick;
					addCookie("userId",userId,2);
					addCookie("userNick",userNick,2);
					window.location.href="edit.html";
				}
				else if(result.status==1)
				{
					//用户名不存在
					$("#count_span").html(result.msg);
				}
				else if(result.status==2)
				{
					//密码错误
					$("#pwd_span").html(result.msg);
				}
			},
			error:function(){
				alert("登录失败");
			}
		});
	}
}


function userRegister()
{
	//获取参数
	var username=$("#regist_username").val().trim();
	var nickname=$("#nickname").val().trim();
	var pwd=$("#regist_password").val().trim();
	var repwd=$("#final_password").val().trim();
	
	//格式检测
	var ok=true;
	
	//$("#count_span").html("");

	
	if(username=="")
	{
		$("#warning_1 span").html("用户名不能为空");
		$("#warning_1").show();
		ok=false;
	}
	//检测密码；1非空，2不能小于6位
	if(pwd=="")
	{
		$("#warning_2 span").html("密码不能为空");
		$("#warning_2").show();
		ok=false;
	}
	else if(pwd.length<6)
	{
		$("#warning_2 span").html("密码不能小于6位");
		$("#warning_2").show();
		ok=false;
	}
	//检测确认密码，1非空，2是否与密码一致
	if(repwd=="")
	{
		$("#warning_3 span").html("密码不能为空");
		$("#warning_3").show();
		ok=false;
	}
	else if(repwd!=pwd)
	{
		$("#warning_3 span").html("两次密码输入不一致");
		$("#warning_3").show();
		ok=false;
	}
	
	//数据校验通过，发送ajax请求
	if(ok)
	{
		$.ajax({
			url:path+"/user/add.do",
			type:"post",
			data:{"name":username,"password":pwd,"nickname":nickname},
			dataType:"json",
			success:function(result){
				if(result.status==0)
				{
					//alert(result.msg);
					//通过id选择器，选择back按钮,返回到登录页面
					$("#back").click();
				}
				else if(result.status==1)
				{
					//用户名已存在
					$("#warning_1 span").html("用户名已存在");
					$("#warning_1").show();
				}
			},
			error:function(){
				alert("注册失败");
			}
		});
	}
}