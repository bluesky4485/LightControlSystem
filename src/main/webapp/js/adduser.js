/**
 * Created by biny on 16-5-15.
 */
function checkform(form){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var authority = document.getElementById("authority").value();

    if( username == ""  ){
        alert("用户名不能为空");
        form.username.focus();
        return false;
    }
    if(password == ""  ) {
        alert("密码不能为空");
        form.password.focus();
        return false;
    }
    if(authority == ""  ) {
        alert("权限不能为空");
        form.password.focus();
        return false;
    }
    return ture;

}