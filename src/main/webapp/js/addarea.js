/**
 * Created by biny on 16-5-18.
 */
function checkform(form){
    var username = document.getElementById("areaname").value;
    var password = document.getElementById("lights").value;

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