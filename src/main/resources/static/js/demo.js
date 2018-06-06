$(function() {
	$("#add").click(add);
	$("#m").hide();
	$("#m").click(m);
});
function add() {
	var url = "/de/add";
	var data = {
				"name":$("#name").val(),
				"age":$("#age").val(),
				"gender":$("input[name='sex']:checked").val(),
				"salary":$("#salary").val(),
				"address":$("#address").val(),
				};
	if($("#name").val().trim() == "" || $("#age").val().trim() == "" || $("#salary").val().trim() == "" || $("#address").val().trim() == ""){
		alert("每条信息都需要填写哟!");
	}else{
		var message = confirm("确定要添加该数据?");
		if(message){
			$.post(url,data,function(result){
				alert($("#name").val() + "的个人信息" + result);
				window.location.reload();
			});
		}
	}
}

function m() {
	var url = "/de/modi";
	var data = {
				"id":$("#m").data("id"),
				"name":$("#name").val(),
				"age":$("#age").val(),
				"gender":$("input[name='sex']:checked").val(),
				"salary":$("#salary").val(),
				"address":$("#address").val(),
				};
	if($("#name").val().trim() == "" || $("#age").val().trim() == "" || $("#salary").val().trim() == "" || $("#address").val().trim() == ""){
		alert("每条信息都需要填写哟!");
	}else{
		var message = confirm("确定要修改该数据?");
		if(message){
			$.post(url,data,function(result){
				alert($("#name").val() + "的个人信息" + result);
				window.location.reload();
			});
		}
	}
}

function del(id){
	var url = "/de/del";
	var data = {"id":id};
	var message = confirm("确定要删除该数据?");
	if(message){
		$.post(url,data,function(result){
			alert(result);
			window.location.reload();
		});
	}
}

function f(user){
	$("#cz").html("查看详情");
	$("#add").hide();
	$("#m").hide();
	zh(user);
}
function modi(user){
	$("#cz").html("修改");
	$("#add").hide();
	$("#m").show();
	zh(user);
}

function zh(user){
	var aa = user.substring(user.indexOf("[") + 1,user.indexOf("]")).replace(/=/g,",").split(",");
	$("#m").data("id",aa[1]);
	$("#name").val(aa[3]);
	$("#age").val(aa[5]);
	$("#salary").val(aa[9]);
	$("#address").val(aa[11]);
	$("input[name='sex']").each(function(){  if($(this).val() == aa[7]) $(this).prop( "checked", true );});
}