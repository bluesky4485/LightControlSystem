/**
 * Created by gch on 16-4-9.
 */
function checkform(form){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

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
    return ture;

}