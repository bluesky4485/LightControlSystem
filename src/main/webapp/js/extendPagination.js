/**
 * Created by Hope on 2014/12/28.
 */

// var tableData = [{"C0":"临夏州_康乐县","C1":190893.39,"C2":24544.65,"AREA_ID":"930013005"},{"C0":"临夏州_永靖县","C1":368900.35,"C2":40592.19,"AREA_ID":"930013006"},{"C0":"兰州市_东岗分局","C1":88.48,"C2":126.4,"AREA_ID":"930013106"},{"C0":"临夏州_临夏县","C1":107337.9,"C2":20612.1,"AREA_ID":"930013008"},{"C0":"临夏州_广河县","C1":69738.07,"C2":34894.44,"AREA_ID":"930013003"},{"C0":"临夏州_和政县","C1":46622.96,"C2":20954.97,"AREA_ID":"930013002"},{"C0":"临夏州_东乡县","C1":96021.84,"C2":16725.63,"AREA_ID":"930013004"},{"C0":"临夏州_临夏市中心","C1":1845311.12,"C2":129478.93,"AREA_ID":"930013001"},{"C0":"天水市_秦州区","C1":0,"C2":0,"AREA_ID":"930013801"},{"C0":"临夏州_积石山","C1":256181.79,"C2":15185.98,"AREA_ID":"930013007"},{"C0":"酒泉_肃州区","C1":264312,"C2":402.6,"AREA_ID":"930013701"}];
// var columns = [{"cid":"info","ctext":"区县"}];
/**
 page:页码
 pageSize:每页的记录条数
 此方法除了传入page和pageSize之外，还应知道的有三个参数：
 一、表的全部数据，json串格式，可通过action查询数据库得到。
 二、表头所对应的列的key及名称，也是json串格式
 三、表所对应的id
 注：此处只是适合表头只有一行，且事先写好的情况。您可以根据需要改一下，逻辑思路就是这样，欢迎批评指正。
 */

function getjson(){
    $.ajax({
        url: '/warning/all.do',//需要添加
        type: "GET",
        dataType: 'json',
        timeout: 1000,
        cache: false,
        beforeSend: LoadFunction, //加载执行方法
        error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    })
}
function LoadFunction() {
    $("#list").html('加载中...');
}

function erryFunction() {
    alert("error");
}

function succFunction(data) {
    
    var tableData = eval(data);
    splitPage(1,10,tableData);

}


function splitPage(page,pageSize,tableData){
    var ptable = document.getElementById("page_table");
    var totalNums = tableData.length;//总行数
    var num = ptable.rows.length;//table.rows返回表格中包含的所有行，此处假设表由表头1行和表体N行组成
    //清除tbody
    for(var i=num-1;i>0;i--){
        ptable.deleteRow(i);
    }
    var totalPage = Math.ceil(totalNums/pageSize);//总页数
    var begin = (page-1)*pageSize;//页起始位置(包括)
    var end = page*pageSize;//页结束位置(不包括)
    end = end>totalNums?totalNums:end;
    //向tbody中写入数据
    var n = 1;//tbody的起始行
    for(var i=begin;i<end;i++){
        var row = ptable.insertRow(n++);
        var rowData = tableData[i];
        var cell0 = row.insertCell(0);
        cell0.innerHTML = rowData.id;
        var cell1 = row.insertCell(1);
        cell1.innerHTML = rowData.light.deviceId;
        var cell2 = row.insertCell(2);
        cell2.innerHTML = rowData.light.groupId;
        var cell3 = row.insertCell(3);
        cell3.innerHTML = rowData.light.inGroupId;
        var cell4 = row.insertCell(4);
        cell4.innerHTML = rowData.info;
        var cell5 = row.insertCell(5);
        cell5.innerHTML = rowData.status;
        var cell6 = row.insertCell(6);
        cell6.innerHTML = rowData.light.infoTime;
        var cell7 = row.insertCell(7);
        cell7.innerHTML = rowData.light.id;
    }
    //生成分页工具条
    var pageBar = "第"+page+"页/共"+totalPage+"页"+" ";
    if(page>1){
        pageBar += "<a href=\"javascript:splitPage("+1+","+pageSize+","+tableData+");\">首页</a> ";
    }else{
        pageBar += "首页 ";
    }
    if(page>1){
        pageBar += "<a href=\"javascript:splitPage("+(page-1)+","+pageSize+","+tableData+");\">上一页</a> ";
    }else{
        pageBar += "上一页 ";
    }
    if(page<totalPage){
        pageBar += "<a href=\"javascript:splitPage("+(page+1)+","+pageSize+","+tableData+");\">下一页</a> ";
    }else{
        pageBar += "下一页 ";
    }
    if(page<totalPage){
        pageBar += "<a href=\"javascript:splitPage("+(totalPage)+","+pageSize+","+tableData+");\">尾页</a> ";
    }else{
        pageBar += "尾页 ";
    }
    document.getElementById("page_bar").innerHTML = pageBar;
}
// $(function(){
//     $.ajax({
//         url:'/warning/all.do',//需要添加
//         type:"GET",
//         dataType: 'json',
//         timeout: 1000,
//         cache: false,
//         beforeSend: LoadFunction, //加载执行方法
//         error: erryFunction,  //错误执行方法
//         success: succFunction //成功执行方法
//     })
//     function LoadFunction() {
//         $("#list").html('加载中...');
//     }
//     function erryFunction() {
//         alert("error");
//     }
//     function succFunction(data) {
//         // $("#list").html('');
//         var jsondata = eval(data);
//         var idonlyArr = new Array();
//         var deviceArr = new Array();
//         var groupArr = new Array();
//         var ingroupArr = new Array();
//         var infoArr = new Array();
//         var statusArr = new Array();
//         var curDateArr = new Array();
//         // var fatherObj = $("#list");
//         $.each(jsondata, function (index,item) {
//             //循环获取数据
//             idonlyArr[index] = index+1;
//
//             var deviceId = item.light.deviceId;
//             deviceArr[index] = deviceId;
//
//             var groupId = item.light.groupId;
//             groupArr[index] = groupId;
//
//             var inGroupId =item.light.inGroupId ;
//             ingroupArr[index] = inGroupId;
//
//             var info = item.info;
//             infoArr[index] = info;
//
//             var status = item.status;
//
//             var infotime = item.infoTime;
//             var date =new Date(parseInt(infotime));
//             var curDate=date.toLocaleString().replace(/年|月/g,"-").replace(/日/g," ");
//             curDateArr[index] = curDate;
//             var ss="N";
//             if(status==1){
//                 ss="Y";
//             }else{
//                 ss="N";
//             }
//             statusArr[index] = ss;
//
//
//         //
//         //     var button = $("<td><button>"+"确认"+"</button></td>")
//         //     button.click(function(event){
//         //         cmd(id_only);
//         //         setTimeout(getjson(),1000);
//         //     })
//         //     if( status == 0){
//         //         idOnlyObj.appendTo(lineObj);
//         //         numObj.appendTo(lineObj);
//         //         deviceIdObj.appendTo(lineObj);
//         //         groupIdObj.appendTo(lineObj);
//         //         inGroupIdOBj.appendTo(lineObj);
//         //         infObj.appendTo(lineObj);
//         //         statusObj.appendTo(lineObj);
//         //         curDateObj.appendTo(lineObj);
//         //         button.appendTo(lineObj);
//         //         lineObj.appendTo(fatherObj);
//         //     }
//         //
//         });
//         $('#callBackPager').extendPagination({
//             totalCount: data.length,
//             showCount: 10,
//             limit: 5,
//             callback: function (curr, limit, totalCount) {
//                 createTable(curr, limit, totalCount);
//             }
//         });
//
//         function cmd(id_only){
//             var xmlHttpRequest = createXmlHttpRequest();
//             xmlHttpRequest.open("POST","/warning/confirm.do?id_only="+id_only,true);//需要改
//             xmlHttpRequest.send(null);
//
//         }
//
//         function createTable(currPage, limit, total) {
//             var html = [], showNum = limit;
//             if (total - (currPage * limit) < 0) showNum = total - ((currPage - 1) * limit);
//             html.push(' <table class="table table-hover piece" style="margin-left: 0;">');
//             // html.push(' <caption>悬停表格(' + total + ')</caption>');
//             html.push(' <thead><tr><th>#</th><th>控制器</th><th>具体组号</th><th>具体灯号</th><th>警情原因</th><th>已处理(Y/N)</th><th>警情时间</th><th>确认</th></tr></thead><tbody>');
//             for (var i = 1; i <= showNum; i++) {
//                 // if(statusArr[(currPage-1) * limit+i-1]=="N"){
//                 html.push('<tr><td>'+idonlyArr[(currPage-1) * limit+i-1]+'</td>');
//                 html.push('<td>'+deviceArr[(currPage-1) * limit+i-1]+'</td>');
//                 html.push('<td>'+groupArr[(currPage-1) * limit+i-1]+'</td>');
//                 html.push('<td>'+ingroupArr[(currPage-1) * limit+i-1]+'</td>');
//                 html.push('<td>'+infoArr[(currPage-1) * limit+i-1]+'</td>');
//                 html.push('<td>'+statusArr[(currPage-1) * limit+i-1]+'</td>');
//                 html.push('<td>'+curDateArr[(currPage-1) * limit+i-1]+'</td>');
//                 html.push('<td><button id='+idonlyArr[(currPage-1) * limit+i-1]+'>'+'确认'+'</button></td>');
//                 html.push('</tr>');
//                 // }
//
//             }
//             html.push('</tbody></table>');
//             var mainObj = $('#mainContent');
//             mainObj.empty();
//             mainObj.html(html.join(''));
//             $("#"+idonlyArr[(currPage-1) * limit+i-1]).click(function(event){
//                 cmd(idonlyArr[(currPage-1) * limit+i-1]);
//                 setTimeout(getjson(),1000);
//             })
//         }
//
//     }
//
//
//
// });
//
//
// $.fn.extendPagination = function (options) {
//     var defaults = {
//         //pageId:'',
//         totalCount: '',
//         showPage: '10',
//         limit: '5',
//         callback: function () {
//             return false;
//         }
//     };
//     $.extend(defaults, options || {});
//     if (defaults.totalCount == '') {
//         //alert('总数不能为空!');
//         $(this).empty();
//         return false;
//     } else if (Number(defaults.totalCount) <= 0) {
//         //alert('总数要大于0!');
//         $(this).empty();
//         return false;
//     }
//     if (defaults.showPage == '') {
//         defaults.showPage = '10';
//     } else if (Number(defaults.showPage) <= 0)defaults.showPage = '10';
//     if (defaults.limit == '') {
//         defaults.limit = '5';
//     } else if (Number(defaults.limit) <= 0)defaults.limit = '5';
//     var totalCount = Number(defaults.totalCount), showPage = Number(defaults.showPage),
//         limit = Number(defaults.limit), totalPage = Math.ceil(totalCount / limit);
//     if (totalPage > 0) {
//         var html = [];
//         html.push(' <ul class="pagination">');
//         html.push(' <li class="previous"><a href="#">&laquo;</a></li>');
//         html.push('<li class="disabled hidden"><a href="#">...</a></li>');
//         if (totalPage <= showPage) {
//             for (var i = 1; i <= totalPage; i++) {
//                 if (i == 1) html.push(' <li class="active"><a href="#">' + i + '</a></li>');
//                 else html.push(' <li><a href="#">' + i + '</a></li>');
//             }
//         } else {
//             for (var j = 1; j <= showPage; j++) {
//                 if (j == 1) html.push(' <li class="active"><a href="#">' + j + '</a></li>');
//                 else html.push(' <li><a href="#">' + j + '</a></li>');
//             }
//         }
//         html.push('<li class="disabled hidden"><a href="#">...</a></li>');
//         html.push('<li class="next"><a href="#">&raquo;</a></li></ul>');
//         $(this).html(html.join(''));
//         if (totalPage > showPage) $(this).find('ul.pagination li.next').prev().removeClass('hidden');
//
//         var pageObj = $(this).find('ul.pagination'), preObj = pageObj.find('li.previous'),
//             currentObj = pageObj.find('li').not('.previous,.disabled,.next'),
//             nextObj = pageObj.find('li.next');
//
//         function loopPageElement(minPage, maxPage) {
//             var tempObj = preObj.next();
//             for (var i = minPage; i <= maxPage; i++) {
//                 if (minPage == 1 && (preObj.next().attr('class').indexOf('hidden')) < 0)
//                     preObj.next().addClass('hidden');
//                 else if (minPage > 1 && (preObj.next().attr('class').indexOf('hidden')) > 0)
//                     preObj.next().removeClass('hidden');
//                 if (maxPage == totalPage && (nextObj.prev().attr('class').indexOf('hidden')) < 0)
//                     nextObj.prev().addClass('hidden');
//                 else if (maxPage < totalPage && (nextObj.prev().attr('class').indexOf('hidden')) > 0)
//                     nextObj.prev().removeClass('hidden');
//                 var obj = tempObj.next().find('a');
//                 if (!isNaN(obj.html()))obj.html(i);
//                 tempObj = tempObj.next();
//             }
//         }
//
//         function callBack(curr) {
//             defaults.callback(curr, defaults.limit, totalCount);
//         }
//
//         currentObj.click(function (event) {
//             event.preventDefault();
//             var currPage = Number($(this).find('a').html()), activeObj = pageObj.find('li[class="active"]'),
//                 activePage = Number(activeObj.find('a').html());
//             if (currPage == activePage) return false;
//             if (totalPage > showPage) {
//                 var maxPage = currPage, minPage = 1;
//                 if (($(this).prev().attr('class'))
//                     && ($(this).prev().attr('class').indexOf('disabled')) >= 0) {
//                     minPage = currPage - 1;
//                     maxPage = minPage + showPage - 1;
//                     loopPageElement(minPage, maxPage);
//                 } else if (($(this).next().attr('class'))
//                     && ($(this).next().attr('class').indexOf('disabled')) >= 0) {
//                     if (totalPage - currPage >= 1) maxPage = currPage + 1;
//                     else  maxPage = totalPage;
//                     if (maxPage - showPage > 0) minPage = (maxPage - showPage) + 1;
//                     loopPageElement(minPage, maxPage)
//                 }
//             }
//             activeObj.removeClass('active');
//             $.each(currentObj, function (index, thiz) {
//                 if ($(thiz).find('a').html() == currPage) {
//                     $(thiz).addClass('active');
//                     callBack(currPage);
//                 }
//             });
//         });
//         preObj.click(function (event) {
//             event.preventDefault();
//             var activeObj = pageObj.find('li[class="active"]'), activePage = Number(activeObj.find('a').html());
//             if (activePage <= 1) return false;
//             if (totalPage > showPage) {
//                 var maxPage = activePage, minPage = 1;
//                 if ((activeObj.prev().prev().attr('class'))
//                     && (activeObj.prev().prev().attr('class').indexOf('disabled')) >= 0) {
//                     minPage = activePage - 1;
//                     if (minPage > 1) minPage = minPage - 1;
//                     maxPage = minPage + showPage - 1;
//                     loopPageElement(minPage, maxPage);
//                 }
//             }
//             $.each(currentObj, function (index, thiz) {
//                 if ($(thiz).find('a').html() == (activePage - 1)) {
//                     activeObj.removeClass('active');
//                     $(thiz).addClass('active');
//                     callBack(activePage - 1);
//                 }
//             });
//         });
//         nextObj.click(function (event) {
//             event.preventDefault();
//             var activeObj = pageObj.find('li[class="active"]'), activePage = Number(activeObj.find('a').html());
//             if (activePage >= totalPage) return false;
//             if (totalPage > showPage) {
//                 var maxPage = activePage, minPage = 1;
//                 if ((activeObj.next().next().attr('class'))
//                     && (activeObj.next().next().attr('class').indexOf('disabled')) >= 0) {
//                     maxPage = activePage + 2;
//                     if (maxPage > totalPage) maxPage = totalPage;
//                     minPage = maxPage - showPage + 1;
//                     loopPageElement(minPage, maxPage);
//                 }
//             }
//             $.each(currentObj, function (index, thiz) {
//                 if ($(thiz).find('a').html() == (activePage + 1)) {
//                     activeObj.removeClass('active');
//                     $(thiz).addClass('active');
//                     callBack(activePage + 1);
//                 }
//             });
//         });
//     }
// };
