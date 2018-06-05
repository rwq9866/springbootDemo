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
	})
}

function del(id){
	var url = "/de/del";
	var data = {"id":id};
	$.post(url,data,function(result){
		console.log(result);
	});
}