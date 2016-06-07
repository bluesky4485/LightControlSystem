<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>节能报表</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script src="../js/dist/Chart.bundle.js"></script>
    <script src="../js/statement.js"></script>

    <style>
        canvas {
            -moz-user-select: none;
            -webkit-user-select: none;
            -ms-user-select: none;
        }
    </style>

</head>
<body>
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <canvas id="canvas"></canvas>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <canvas id="lightrate"  />
        </div>
        <div class="col-sm-6">
            <canvas id="failurerate"  />
        </div>
    </div>
</body>
</html>