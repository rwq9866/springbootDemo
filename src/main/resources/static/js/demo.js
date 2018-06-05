$(function() {
	$("#add").click(add);
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
	$.post(url,data,function(result){
		$("#aa").html(result);
		window.location.reload();
	});
}

function del(id){
	var url = "/de/del";
	var data = {"id":id};
	$.post(url,data,function(result){
		console.log(result);
		window.location.reload();
	});
}

function f(user){
	alert(user);
	var obj2=eval("("+user+")");  
	console.log(obj2);
	console.log(obj2.id);
	console.log(typeof obj2);
}
function modi(id){
	
}