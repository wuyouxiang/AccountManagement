var table;
var flag=0;
//查询条件处的select2插件
$(function(){
	var data = [{ id: '正式', text: '正式' }, { id: '试用', text: '试用' }];
	$("#c01-select").select2({
	  data: data,
	  placeholder:'请选择',
	  allowClear:true
	});
	$("#c01-select").select2("val", ""); 
});
//加载表格数据
$(document).ready(function() {
	reload();
});
//daterangepicker
$(document).ready(function() {
	$('#reservation').daterangepicker();
	$('#reservation').val("");
} );
//添加一个“添加新账号”的按钮
$(document).ready(function() {
	setTimeout(add,1000);
} );
//点击“添加新账号”事件
function addForm(){
	if(flag==1){
		alert("请先保存");
		return;
	}
	$("#addbuton").before("<tr role='row' class='odd'><td class='sorting_1'>" +
			"<input id='addid' class='form-control'/></td>" +
			"<td><input id='addname' class='form-control'/></td>" +
			"<td><input id='addremark' class='form-control'/></td>" +
			"<td><input id='addstate' class='form-control'/></td>" +
			"<td><input id='addcreatetime' disabled='true' value='"+new Date()+"  ' class='form-control'/></td>" +
			"<td><input id='addloadtime' disabled='true' value='"+new Date()+"  ' class='form-control'/></td>" +
			"<td><select id='c02-select' class='form-control'></select></td>" +
			"<td><button class='btn btn-info btn-block' onclick='saveAccount();'>保存</button></td></td></tr>");
	var data = [{ id: '正式', text: '正式' }, { id: '试用', text: '试用' }];
	$("#c02-select").select2({
	  data: data,
	  placeholder:'请选择',
	  allowClear:true
	});
	flag=1;
}
//点击保存事件
function saveAccount(){
	var id=$("#addid").val();
	if(id !== null && id !== undefined && id !== ''){
		$.ajax({
			url:"/addForm",
			data:{
				"id":$("#addid").val(),
				"name":$("#addname").val(),
				"remark":$("#addremark").val(),
				"state":$("#addstate").val(),
				"type":$("#c02-select").val()},
			success:function(data){
				alert("成功");
				reload();
				setTimeout(add,500);
			},
			error:function(){
				alert("已存在相同编码");
				reload();
				setTimeout(add,500);
			}
		});
	}else{
		alert("id不能为空");
	}
}
//保存修改
function saveModify(){
	$.ajax({
		url:"/modify",
		data:{
			"id":$("#addid").val(),
			"name":$("#addname").val(),
			"remark":$("#addremark").val(),
			"state":$("#addstate").val(),
			"type":$("#c02-select").val()},
		success:function(data){
			alert("成功");
			reload();
			setTimeout(add,500);
		}
	});
}
//生成“添加新账号”按钮
function add(){
	var tr=document.createElement("tr");
	var td=document.createElement("td");
	$(td).attr("colspan","8");
	$(td).append("<button id='add' class='btn btn-info btn-block' onclick='addForm();' style=''>添加新账号</button>");
	tr.appendChild(td);
	$(tr).attr("role","row");
	$(tr).attr("class","odd");
	$(tr).attr("id","addbuton");
	document.querySelector("tbody").appendChild(tr);
}
//刷新表格数据
function reload(){
	flag=0;
	table =$('#table_id_example').DataTable({  
		bFilter: false,
		ordering: false,
		destroy: true,
		ajax : {
			url:"/find",
			data:{"id":$("#findid").val(),
				 "name":$("#findname").val(),
				 "type":$("#c01-select").val(),
				 "period":$('#reservation').val()}
		},
        columns: [
            {
                "data": "id"
            },
            {
                "data": "name"
            },
            {
                "data": "remark"
            },
            {
                "data": "state"
            },
            {
                "data": function(obj){  
                    var newDate = new Date();
                    newDate.setTime(obj.createtime);
                    return newDate.toLocaleDateString();//<span style="color:#ff0000;">通过调用函数来格式化所获取的时间戳</span>  
                } 
            },
            {
                "data": function(obj){  
                    var newDate = new Date();
                    newDate.setTime(obj.lastloadtime);
                    return newDate.toLocaleDateString();//<span style="color:#ff0000;">通过调用函数来格式化所获取的时间戳</span>  
                }
            },
            {
                "data": "type"
            }],
            columnDefs : [ {
            	// 定义操作列,######以下是重点########
            	"targets" : 7,//操作按钮目标列
            	"data" : null,
            	"render" : function(data, type,row) {
            		var sea="解封";
            		if(data.sealed==true){
            			sea="封存";
            		}
	            	var html = '<button id="modify" class="delete btn btn-default btn-xs" > 修改</button>';
	            	html += '<button id="delete" class="up btn btn-default btn-xs">删除</button>';
	            	html += '<button id="sealed"  class="btn btn-default btn-xs">'+sea+'</button>';
	            	return html;
	            	}
            	} ]
    });
}
//点击查询事件
function find(){
	reload();
	setTimeout(add,500);
}
//点击修改事件
$(document).on("click","#modify",function(e){
	if(flag==1){
		alert("请先保存");
		return;
	}
	 var rowdata = table.row($(this).closest('tr')).data();
	 $(this).closest('tr').before("<tr role='row' class='odd'><td class='sorting_1'>" +
				"<input id='addid' value='"+rowdata.id+"' disabled='true' class='form-control'/></td>" +
				"<td><input id='addname' value='"+rowdata.name+"' class='form-control'/></td>" +
				"<td><input id='addremark' value='"+rowdata.remark+"' class='form-control'/></td>" +
				"<td><input id='addstate' value='"+rowdata.state+"' class='form-control'/></td>" +
				"<td><input id='addcreatetime' value='"+rowdata.createtime+"' disabled='true' value='"+new Date()+"  ' class='form-control'/></td>" +
				"<td><input id='addloadtime' value='"+rowdata.lastloadtime+"' disabled='true' value='"+new Date()+"  ' class='form-control'/></td>" +
				"<td><select id='c02-select' class='form-control'></select></td>" +
				"<td><button class='btn btn-info btn-block' onclick='saveModify();'>保存修改</button></td></td></tr>");
		var data = [{ id: '正式', text: '正式' }, { id: '试用', text: '试用' }];
		$("#c02-select").select2({
		  data: data,
		  placeholder:'请选择',
		  allowClear:true
		});
		$(this).closest('tr').remove();
		flag=1;
});
//点击删除事件
$(document).on("click","#delete",function(e){
	if(flag==1){
		alert("请先保存");
		return;
	}
	var rowdata = table.row($(this).closest('tr')).data();
	$.ajax({
		url:"/delete",
		data:{"id":rowdata.id},
		success:function(){
			alert("删除成功");
			reload();
			setTimeout(add,500);
		}
	});
});
//点击封存事件
$(document).on("click","#sealed",function(e){
	if(flag==1){
		alert("请先保存");
		return;
	} 
	var rowdata = table.row($(this).closest('tr')).data();
	$.ajax({
		url:"/sealed",
		data:{"id":rowdata.id,"sealed":rowdata.sealed},
		success:function(){
			alert("操作成功");
			reload();
			setTimeout(add,500);
		}
	});
});