<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="../../css/Hrlogin/pintuer.css">
    <link rel="stylesheet" href="../../css/Hrlogin/admin.css">
    <script src="../../js/lib/jquery.js"></script>
    <!-- 输入合法性的验证 -->
    <script src="../../js/pintuer.js"></script>
    <!-- 定时显示提示信息 -->
    <%--<script language="javascript">--%>
    <%--function codefans() {--%>
    <%--var box = document.getElementById("msg");--%>
    <%--box.style.display = "none";--%>
    <%--}--%>
    <%--setTimeout("codefans()", 3000);--%>
    <%--</script>--%>
</head>
<body>

<div class="panel admin-panel">
    <div class="panel-head">
        <strong> 修改用户密码</strong>
    </div>
    <div class="body-content">
        <form  action="/safe/UpdatePwd.html" method="post" class="form-x">
            <div class="form-group">
                <div class="label">
                    <label>用户帐号：</label>
                </div>
                <div class="field">
                    <label style="line-height: 33px;"> ${userNow.username}</label>
                    <span id="msg" style="margin-left: 60px; color: #ff0000;">${updatepwdmsg}</span>
                </div>

            </div>

            <div class="form-group">
                <div class="label">
                    <label>原始密码：</label>
                </div>
                <div class="field">

                    <input type="password" class="input w50" id="mpass" name="mpass"
                           size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>新密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="newpass" size="50"
                           placeholder="请输入新密码"
                           data-validate="required:请输入新密码,length#>=3:新密码不能小于3位"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>确认新密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="renewpass"
                           size="50" placeholder="请再次输入新密码"
                           data-validate="required:请再次输入新密码"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main " type="submit">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>