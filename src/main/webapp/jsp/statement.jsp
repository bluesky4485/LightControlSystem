<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html charset=utf-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>节能报表</title>
    <link href="../css/bootstrap.css" rel="stylesheet" />
    <script src="../js/jquery/jquery-1.9.1.js"></script>
    <%--<script src="../js/bootstrap.js"></script>--%>
    <script src="../js/dist/Chart.bundle.js"></script>
    <style>
        canvas {
            -moz-user-select: none;
            -webkit-user-select: none;
            -ms-user-select: none;
        }
    </style>
    <%--<script src="../js/Chart.js"></script>--%>

</head>
<body >
<div style="width: 50%">
    <canvas id="canvas"></canvas>
</div>
<%--<button id="randomizeData">Randomize Data</button>--%>

<div id="canvas-holder" style="width:50%">
    <canvas id="chart-area"  />
</div>

<script src="../js/right1.js"></script>

</body>
</html>