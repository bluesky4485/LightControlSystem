<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>高杆灯</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <script src="../js/bootstrap.js"></script>
    <link href="../css/jquery.range.css" rel="stylesheet" />
    <script src="../js/jquery/jquery.range.js"></script>

    <link href="../css/style.css" rel="stylesheet" />
    <link href="../css/admin.css"  rel="stylesheet"/>
    <link href="../css/jquery-ui2.css" rel="stylesheet"  />
    <script src="../js/jquery/jquery.artDialog.js?skin=idialog"></script>

    <%--<link href="../css/imcontrol.css" rel="stylesheet"  />--%>
    <%--<script src="../js/right2_2.js"></script>--%>
    <script src="../js/imcontrol.js"></script>
</head>
<body>
<div class="row">
    <div class="col-xs-4 col-xs-offset-4" style="border: 1px solid forestgreen;">
        <h4 class="text-primary" style="text-align: center">灯的亮度</h4><br>
        <div class="row">
            <div class="col-xs-10 col-xs-offset-1">
                <input  type="hidden" class="single-slider" />
            </div>
        </div><br><br>
    </div>
</div>

<div class="row">
    <div class="col-xs-4 col-xs-offset-4" style="border: 1px solid forestgreen;">
        <h4 class="text-primary" style="text-align: center">灯的选择</h4><br>
        <div class="row">
            <div class="col-xs-8 col-xs-offset-3">
                <input id="notall" style="float: left;" type="radio" name="suoyou"  value="0" checked="checked">
                <h4 style="float: left;">非所有灯&nbsp;&nbsp;</h4>
                <input id="all" style="float: left;" type="radio" name="suoyou" value="1" >
                <h4 style="float: left;">所有的灯</h4>
            </div>
        </div><br>
    </div>
</div>

<div id="choose_light"　class="row">
    <div class="col-xs-10 col-xs-offset-1" style="border: 1px solid forestgreen;">
        <br>
        <div class="row">
            <div class="col-xs-4">
                <input type="text" id="jizhongtxt" style="width: 50%;"/>
                <button   id="jizhong" class=" btn-primary" >
                    <div style="display:none" id="selectjizhong"></div>
                    选择集中选择器
                </button>
            </div>
            <div class="col-xs-4">
                <input type="text" id="zutxt" style="width: 50%;"/>
                <button   id="zu" class=" btn-primary" >
                    <div style="display:none" id="selectzu"></div>
                    选择具体组号
                </button>
            </div>
            <div class="col-xs-4">
                <input type="text" id="lighttxt" style="width: 50%;"/>
                <button   id="light" class="btn-primary" >
                    <div style="display:none" id="selectlight"></div>
                    选择具体灯号
                </button>
            </div>
        </div>
        <br>
    </div>
</div><br>
<div class="row">
    <div class="col-xs-12" style="text-align: center">
        <input type="button" class="btn btn-primary active" id="imControl" value="控制" />
    </div>
</div>

        <%--<div class="chooselight">--%>
                <%--<h4 class="text-primary">灯的亮度</h4><br>--%>
                <%--<div class="div1311">--%>
                    <%--<input  type="hidden" class="single-slider"/>--%>
                <%--</div>--%>
        <%--</div>--%>
        <%--<div class="div2_1">--%>
            <%--<h4 class="text-primary">灯的选择</h4><br>--%>
            <%--<div style="margin:0 auto;width: 50%;min-width: 200px;">--%>
                <%--<input id="notall" class="flo1" type="radio" name="suoyou"  value="0" checked="checked">--%>
                <%--<h4 class="flo1">非所有灯</h4>--%>
                <%--<input id="all" class="flo1" type="radio" name="suoyou" value="1" >--%>
                <%--<h4 class="flo1">所有的灯&nbsp;</h4>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div id="choose_light" class="div2_2">--%>
            <%--<div class="div2_2_1">--%>
                <%--<div style="width: 100%">--%>
                    <%--<input type="text" id="jizhongtxt" style="width: 50%;"/>--%>
                    <%--<button   id="jizhong" class=" btn-primary" >--%>
                        <%--<div style="display:none" id="selectjizhong"></div>--%>
                        <%--选择集中选择器--%>
                    <%--</button>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="div2_2_2">--%>
                <%--<div style="width: 100%">--%>
                    <%--<input type="text" id="zutxt" style="width: 50%;"/>--%>
                    <%--<button   id="zu" class=" btn-primary" >--%>
                        <%--<div style="display:none" id="selectzu"></div>--%>
                        <%--选择具体组号--%>
                    <%--</button>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="div2_2_2">--%>
                <%--<div style="width: 100%">--%>
                    <%--<input type="text" id="lighttxt" style="width: 50%;"/>--%>
                    <%--<button   id="light" class=" btn-primary" >--%>
                        <%--<div style="display:none" id="selectlight"></div>--%>
                        <%--选择具体灯号--%>
                    <%--</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div><br>--%>
        <%--<div>--%>
            <%--<input type="button" class="btn btn-primary active" id="imControl" value="&nbsp;&nbsp;控制&nbsp;&nbsp;" />--%>
        <%--</div>--%>
</body>
</html>
