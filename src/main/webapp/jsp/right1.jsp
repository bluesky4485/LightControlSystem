<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>高杆灯</title>
    <link href="../css/theme.min.css" type="text/css" rel="stylesheet" />
    <link href="../css/style2.css" type="text/css" rel="stylesheet" />
    <script src="../js/right1.js"></script>
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../js/script.js"></script>
    <style type="text/css">

        html{height:100%}

        body{height:100%;margin:0px;padding:0px}

        #container{height:100%}

    </style>

    <script src="http://api.map.baidu.com/api?v=1.4" type="text/javascript"></script>

</head>
<body style="width: 100%;text-align: center">
<%--<div class="aboluo-w-700" style="margin:0 auto">--%>
    <%--<div class="aboluo-leftdiv">--%>
        <%--<div class="aboluo-tools">--%>
            <%--<div class="aboluo-calendar-select-year"></div>--%>
            <%--<div class="aboluo-calendar-month">--%>
                <%--<a class="aboluo-month-a-perv" href="javascript:;">&lt; </a>--%>
                <%--<a class="aboluo-month-a-next" href="javascript:;"> &gt;</a>--%>
            <%--</div>--%>
            <%--<input type="button" class="aboluo-toToday" value="返回今天" />--%>
        <%--</div>--%>
        <%--<div class="aboluo-rilidiv">--%>
            <%--<table class="aboluo-rilitable" cellspacing="0" cellpadding="0" >--%>
                <%--<thead class="aboluo-rilithead">--%>
                <%--<tr>--%>
                    <%--<th>一</td>--%>
                    <%--<th>二</td>--%>
                    <%--<th>三</td>--%>
                    <%--<th>四</td>--%>
                    <%--<th>五</td>--%>
                    <%--<th style="color:red;">六</td>--%>
                    <%--<th style="color:red;">日</td>--%>
                <%--</tr>--%>
                <%--</thead>--%>
            <%--</table>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="aboluo-rightdiv">--%>
        <%--<p class="aboluo-xssj"><p>--%>
        <%--<p class="aboluo-currday"></p>--%>
        <%--<p class="aboluo-ssjjr"></p>--%>
        <%--<p class="aboluo-xsmx"></p>--%>
    <%--</div>--%>
<%--</div>--%>


<%--<input type="text" id="cityName" value="上海金山"/>--%>

<%--<input type="button" onclick="setCity()" value="查找" />--%>

<%--<div id="container" style="width:100%;height: 600px;"></div>--%>





<%--<script type="text/javascript">--%>

    <%--var map = new BMap.Map("container");        //在container容器中创建一个地图,参数container为div的id属性;--%>



    <%--var point = new BMap.Point(120.2,30.25);    //创建点坐标--%>

    <%--map.centerAndZoom(point, 14);                //初始化地图，设置中心点坐标和地图级别--%>

    <%--map.enableScrollWheelZoom();                //激活滚轮调整大小功能--%>

    <%--map.addControl(new BMap.NavigationControl());    //添加控件：缩放地图的控件，默认在左上角；--%>

    <%--map.addControl(new BMap.MapTypeControl());        //添加控件：地图类型控件，默认在右上方；--%>

    <%--map.addControl(new BMap.ScaleControl());        //添加控件：地图显示比例的控件，默认在左下方；--%>

    <%--map.addControl(new BMap.OverviewMapControl());  //添加控件：地图的缩略图的控件，默认在右下方； TrafficControl--%>



    <%--var search = new BMap.LocalSearch("中国", {--%>

        <%--onSearchComplete: function(result){--%>

            <%--if (search.getStatus() == BMAP_STATUS_SUCCESS){--%>

                <%--var res = result.getPoi(0);--%>

                <%--var point = res.point;--%>

                <%--map.centerAndZoom(point, 11);--%>

            <%--}--%>

        <%--},renderOptions: {  //结果呈现设置，--%>

            <%--map: map,--%>

            <%--autoViewport: true,--%>

            <%--selectFirstResult: true--%>

        <%--} ,onInfoHtmlSet:function(poi,html){//标注气泡内容创建后的回调函数，有了这个，可以简单的改一下返回的html内容了。--%>

            <%--// alert(html.innerHTML)--%>

        <%--}//这一段可以不要，只不过是为学习更深层次应用而加入的。--%>

    <%--});--%>



    <%--function setCity(){--%>

        <%--search.search(document.getElementById("cityName").value);--%>

    <%--}--%>



    <%--search.search(document.getElementById("cityName").value);--%>





<%--</script>--%>

</body>
</html>