<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>高杆灯</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <script src="../js/bootstrap.js"></script>

    <link href="../css/jquery.datetimepicker.css" rel="stylesheet" />
    <script src="../js/jquery.js"></script>
    <script src="../js/jquery.datetimepicker.full.js"></script>

    <link href="../css/jquery.range.css" rel="stylesheet" />
    <script src="../js/jquery/jquery.range.js"></script>

    <link href="../css/style.css" rel="stylesheet" />
    <link href="../css/admin.css"  rel="stylesheet"/>
    <link href="../css/jquery-ui2.css" rel="stylesheet"  />
    <script src="../js/jquery/jquery.artDialog.js?skin=idialog"></script>

    <%--<link href="../css/timecontrol.css" rel="stylesheet"  />--%>
    <script src="../js/timecontrol.js"></script>
</head>
<body style="text-align: center">
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
           <h4 class="text-primary" style="text-align: center">任务时间</h4><br>
           <div class="row">
               <div class="col-xs-12" >
                   <input name="act_start_time" id="act_start_time" type="text"  value="" placeholder="开灯时间" style="cursor: pointer;"/>
                   <input name="act_stop_time" id="act_stop_time" type="text"  value="" placeholder="关灯时间"  style="cursor: pointer;"/>
               </div>
           </div><br>
       </div>
   </div>

   <div class="row">
       <div class="col-xs-4 col-xs-offset-4" style="border: 1px solid forestgreen;">
           <h4 class="text-primary" style="text-align: center">灯的选择</h4><br>
           <div class="row">
               <div class="col-xs-10 col-xs-offset-2">
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
   </div>
   <div class="row">
       <div class="col-xs-12" style="text-align: center">
           <input type="button" class="btn btn-primary active" id="timeControl" value="控制" />
       </div>
   </div>
</body>
</html>