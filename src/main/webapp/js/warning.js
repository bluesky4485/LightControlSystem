/**
 * Created by chgu1_000 on 2016/3/23.
 */
var page=0;
$(document).ready(function () {
    getWarning();
});
function deleteRow(){
    $("table#test tr").click(function() {
        $(this).remove();
        deleteWarning($(this).find("td").eq(0).text());
    });

};

function createXmlHttpRequest(){
    if(window.ActiveXObject){ //如果是IE浏览器
        return new ActiveXObject("Microsoft.XMLHTTP");
    }else if(window.XMLHttpRequest){ //非IE浏览器
        return new XMLHttpRequest();
    }
}


function deleteWarning(id_only){
    var xmlHttpRequest = createXmlHttpRequest();
    xmlHttpRequest.open("POST","/warning/confirm.do?id_only="+id_only,true);//需要改
    xmlHttpRequest.send(null);

}
function getWarning(){
    $.ajax({
        type: "post",
        dataType: "json",
        url: "/warning/all.do",
        data: { "page": parseInt(page + 1) },
        success: function (req) {
            var data = eval(req);
            $.each(data, function (index,item){
                //循环获取数据
                item.infoTime =  getLocalTime(item.infoTime);
            });
            $("#result").setTemplateElement("template");
            $("#result").processTemplate(data);
        }
    });
}
//时间戳转成日期格式
function add0(m){return m<10?'0'+m:m }
function getLocalTime(nS) {
    var time = new Date(parseInt(nS));
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
}

function nextPage() {
    page++;
    getWarning();
}

function prePage() {
    page--;
    if(page<0){
        page=0;
    }
    getWarning();
}

function firstPage() {
    page=0;
    getWarning();
}