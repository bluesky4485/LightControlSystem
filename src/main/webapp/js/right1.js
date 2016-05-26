//var randomScalingFactor = function() {
//    return (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100);
//};
//var randomColorFactor = function() {
//    return Math.round(Math.random() * 255);
//};


window.onload = function() {
    ajax();
    ajax2();
}


function  ajax(){
    $.ajax({
        url:'/lightstatus/pow.do',//需要添加
        type:"GET",
        dataType: 'json',
        timeout: 1000,
        cache: false,
        //beforeSend: LoadFunction, //加载执行方法
        //error: erryFunction,  //错误执行方法
        success: succFunction //成功执行方法
    })
}

function succFunction(data) {

    var barChartData = {
        labels: ["上月", "本月", "去年同期"],
        datasets: [
            {
                label:["上月"],
                backgroundColor: "rgba(151,187,205,0.5)",
                data: [data[0]*60,0,0]
            },
            {
                label:["本月"],
                backgroundColor: "rgba(255,187,205,0.5)",
                data: [0,data[1]*60,0]
            },
            {
                label:["去年同期"],
                backgroundColor: "rgba(151,255,205,0.5)",
                data: [0,0,data[2]*60]
            }
        ]
    };

    var ctx = document.getElementById("canvas").getContext("2d");
    window.myBar = new Chart(ctx, {
        type: 'bar',
        data: barChartData,
        options: {
            title:{
                display:true,
                text:"月度总耗能(kw*h)",
            },
            tooltips: {
                mode: 'label'
            },
            responsive: true,
            scales: {
                xAxes: [{
                    stacked: true,
                }],
                yAxes: [{
                    stacked: true
                }]
            }
        }
    });
};

function  ajax2(){
    $.ajax({
        url:'/lightstatus/all.do',//需要添加
        type:"GET",
        dataType: 'json',
        timeout: 1000,
        cache: false,
        //beforeSend: LoadFunction, //加载执行方法
        //error: erryFunction,  //错误执行方法
        success: succFunction2 //成功执行方法
    })
}

function succFunction2(data) {
    var jsonData = eval(data);
    var i = 0;
    $.each(jsonData, function (index,item) {
        var bright = item.bright;
        if(bright!=0){
            i++;
        }
    });


    var j=(i/jsonData.length)*100;
    var config = {
        type: 'pie',
        data: {
            datasets: [{
                data: [
                    i,
                    jsonData.length-i,
                ],
                backgroundColor: [
                    "rgba(255,187,205,0.5)",
                    "#4D5360",
                ],
            }],
            labels: [
                "开灯",
                "关灯"
            ]
        },
        options: {
            responsive: true,
            title:{
                display:true,
                text:"亮灯率"+j+"%"
            }
        }
    };

    var ctx2 = document.getElementById("chart-area").getContext("2d");
    window.myPie = new Chart(ctx2, config);


}











