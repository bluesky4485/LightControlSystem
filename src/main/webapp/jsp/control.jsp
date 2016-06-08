<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>控制策略</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <script src="../js/bootstrap.js"></script>
</head>
<body>
    <div class="row">
        <br>
        <div class="col-xs-2 col-sm-2 col-xs-offset-3 col-sm-offset-3 ">
            <a href="timecontrol.jsp" class="btn btn-primary active" target="control">
                定时控制
            </a>
        </div>
        <div class="col-xs-2 col-sm-2">
            <a href="imcontrol.jsp" class="btn btn-primary active" target="control">
                即时控制
            </a>
        </div>
        <div class="col-xs-2 col-sm-2">
            <a href="sitecontrol.jsp" class="btn btn-primary active" target="control">
                经纬度控制
            </a>
        </div>
        <div class="col-xs-2 col-sm-2">
            <a href="suncontrol.jsp" class="btn btn-primary active" target="control">
                光照控制
            </a>
        </div>
    </div>

    <hr style="border: 1px blue solid"/>

    <div class="row">
        <div class="col-xs-12 col-sm-12">
            <iframe name="control" style="width: 100%;height: 100%" scrolling="no" frameborder="no" src="timecontrol.jsp">
            </iframe>
        </div>
    </div>

</body>
</html>
