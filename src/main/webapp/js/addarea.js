/**
 * Created by biny on 16-5-18.
 */
function checkform(form){
    var userid = document.getElementById("areaid").value;
    var username = document.getElementById("areaname").value;
    var password = document.getElementById("lights").value;
    if( userid == ""  ){
        alert("区域编号不能为空");
        form.userid.focus();
        return false;
    }

    if( username == ""  ){
        alert("区域名不能为空");
        form.username.focus();
        return false;
    }
    if(password == ""  ) {
        alert("灯号不能为空");
        form.password.focus();
        return false;
    }
    
    return ture;

}