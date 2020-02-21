function loadSelect(typecode,positionid,selecteName,selectedId){
    //创建select下拉选对象
    var $select = $("<select name="+selecteName+"></select>");
    //创建提示option
    $select.append($("<option value=''>---请选择---</option>"));
    //使用jquery 的ajax 方法,访问后台Action
    $.post("${pageContext.request.contextPath}/BaseDictAction", {"dict_type_code":typecode},
        function(data){
            //alert(data);
            //遍历返回结果，创建option选项
            $.each( data, function(i, obj){
                var $option = $("<option value='"+obj['dict_id']+"'>"+obj["dict_item_name"]+"</option>");
                //判断是否回显
                if(obj['dict_id'] == selectedId){
                    //判断是否需要回显 ,如果需要使其被选中
                    $option.attr("selected","selected");
                }
                $select.append($option);
            });
        }, "json");
    //将下拉选添加到指定位置
    $("#"+positionid).append($select);
}

function addSelect(selectedId) {
    var $select = $("<select name='user.user_id'></select>");
    $select.append($("<option value=''>---请选择---</option>"));
    $.post("${pageContext.request.contextPath}/UserAction_list",
        function(data){
            $.each( data, function(i, json){
                var $option = $("<option value='"+json['user_id']+"'>"+json["user_name"]+"</option>")
                if(json['user_id'] == selectedId){
                    //判断是否需要回显 ,如果需要使其被选中
                    $option.attr("selected","selected");
                }
                $select.append($option)
            });
        }, "json");
    $("#username").append($select);
}