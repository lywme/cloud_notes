$(function(){
	//显示笔记本列表
	loadUserBooks();
	//绑定笔记本单击事件
	$("#book_ul").on("click","li",function(){
		var bookId=$(this).data("bookId");
		
		//清除之前选中的笔记本效果
		$("#book_ul a").removeClass("checked");
		//设置高亮选中的笔记本的效果
		$(this).find("a").addClass("checked");
		
		//console.log(bookId);
		
		//每次添加列表前，清空元素中已有的数据
		$("#note_ul").empty();
		
		$.ajax({
			url:path+"/note/loadnotes.do",
			type:"post",
			data:{"bookId":bookId},
			dataType:"json",
			success:function(result)
			{
				if(result.status==0)
				{
					var data=result.data;
					for(i=0;i<data.length;i++)
					{
						var noteId=data[i].cn_note_id;
						var noteTitle=data[i].cn_note_title;
						//创建笔记列表项的Li元素
						createNoteLi(noteId,noteTitle);
					}
				}
			},
			error:function(){
				//alert("笔记列表加载失败");
			}
		});
	});
	
	$("#note_ul").on("click","li",function(){
		var noteId=$(this).data("noteId");
		console.log(noteId);
	});
});

function loadUserBooks()
{
	//根据用户id显示笔记本列表
	var userId=getCookie("userId");
	//console.log(userId);
	//发送ajax请求获取用户的笔记本列表
	//发送请求
	if(userId!=null)
	{
		$.ajax({
			url:path+"/book/loadBooks.do",
			type:"post",
			data:{"userId":userId},
			dataType:"json",
			success:function(result){
				if(result.status==0)
				{
					var books=result.data;
					for(var i=0;i<books.length;i++)
					{
						var bookId=books[i].cn_notebook_id;
						var bookName=books[i].cn_notebook_name;
						//console.log(bookId)
						//创建笔记本列表项的Li元素
						createBookLi(bookId,bookName);
					}
				}
			},
			error:function(){
				alert("获取用户笔记本列表失败");
			}
		});
	}
	else
	{
		windows.location.href("log_in.html");
	}
};

//创建笔记本列表项的Li元素
function createBookLi(bookId,bookName)
{
	var sli="";
	sli+="<li class='online'>";
	sli+="<a><i class='fa fa-book' title='online' rel='tooltip-bottom'></i>";
	sli+=bookName;
	sli+="</a></li>";
	//将li字符串，转换成JQuery的对象li元素
	var $li=$(sli);
	//将bookId值与jquery对象绑定
	$li.data("bookId",bookId);
	//将li元素添加到笔记本ul列表区
	$("#book_ul").append($li);
};

//创建笔记列表项的Li元素
function createNoteLi(noteId,noteTitle)
{
	var nli="";
	nli+='<li class="online">';
	nli+="<a>";
	nli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> '+noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	nli+="</a>";
	nli+='<div class="note_menu" tabindex="-1">';
	nli+='	<dl>';
	nli+='		<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
	nli+='		<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	nli+='		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	nli+='	</dl>';
	nli+='</div></li>';
	//将nli字符串，转换成JQuery的对象li元素
	var $li=$(nli);
	//将bookId值与jquery对象绑定
	$li.data("noteId",noteId);
	//将li元素添加到笔记本ul列表区
	$("#note_ul").append($li);
}
