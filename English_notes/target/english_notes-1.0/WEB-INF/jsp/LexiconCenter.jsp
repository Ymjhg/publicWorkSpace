<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/Hrlogin/pintuer.css">
    <link rel="stylesheet" href="../../css/Hrlogin/admin.css">
    <script language="JavaScript" src="../../js/lib/jquery.min.1.11.3.js"></script>
    <script src="../../js/lib/jquery.js"></script>
    <script type="text/javascript" src="../../js/lib/SuperSlide.2.1.1.js"></script>
    <script type="text/javascript">
        $(function () {
            jQuery(".sideMenu").slide({
                titCell: "h3", //鼠标触发对象
                targetCell: "ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
                effect: "slideDown", //targetCell下拉效果
                delayTime: 300, //效果时间
                triggerTime: 150, //鼠标延迟触发时间（默认150）
                defaultPlay: true,//默认是否执行效果（默认true）
                returnDefault: true //鼠标从.sideMen移走后返回默认状态（默认false）
            });
        })

    </script>
    <style type="text/css">
        /* css 重置 */
        *{margin:0; padding:0; list-style:none; }
        body{ background:#fff; font:normal 12px/22px 宋体;  }
        img{ border:0;  }
        a{ text-decoration:none; color:#333;  }
        .js{width:90%; margin:10px auto 0 auto; }
        .js p{ padding:5px 0; font-weight:bold; overflow:hidden;  }
        .js p span{ float:right; }
        .js p span a{ color:#f00; text-decoration:underline;   }
        .js textarea{ height:50px;  width:98%; padding:5px; border:1px solid #ccc; border-top:2px solid #aaa;  border-left:2px solid #aaa;  }


        /* 本例子css */
        .sideMenu{  border:1px solid #ddd; width: 180px;background-color: #F2F9FD;float: left; position: absolute;left: 0;top: 120px;bottom: 0;}
        .sideMenu h3{ height:32px; line-height:32px; padding-left:10px;  border-top:1px solid #e3e3e3; background:#F2F9FD; cursor:pointer;
            font:normal 14px/32px "Microsoft YaHei";
        }
        .sideMenu h3 em{ float:right; display:block; width:40px; height:32px;   background:url(../../images/icoAdd.png) 16px 12px no-repeat; cursor:pointer; }
        .sideMenu h3.on em{ background-position:16px -57px; }
        .sideMenu ul{ padding:8px 25px 8px 45px; color:#999; display:none; /* 默认都隐藏 */ }

        .div_right{
            position: absolute;left: 180px;top: 120px;right: 0;bottom: 0;
        }

    </style>
</head>


<body>
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1 style="font-weight: 700">
            <img src="../../images/y.jpg" class="radius-circle rotate-hover"
                 height="50" alt=""/>词库中心
        </h1>
    </div>
    <div class="head-l">
        <a class="button button-little bg-blue"> 用户：${userNow.username }</a>
        &nbsp;&nbsp;
        <a class="button button-little bg-red" href="/shortcut/UserLogin"> 退出登录</a>

    </div>
</div>
<div>
    <h3 style="width:180px;height:50px;background-color:#1381BC;padding:10px;color: #fff;display: inline-block;text-align: center;line-height: 30px;font-weight: 700">
        <em style="float:right; display:block; width:40px; height:32px"></em>功能列表</h3>
    <div style="display: inline-block;padding:8px;background-color:#F2F9FD;position: absolute;left: 180px;top: 70px;right: 0">
        <a>首页</a> /
        <a>网站信息</a>
    </div>
</div>
<div>
    <div class="sideMenu" style="margin:0 auto;">

        <h3 class="on" style="text-align: center;font-weight: 700"><em></em>英文词库管理</h3>
        <!-- 假设当前频道为“幻灯片/焦点图系列”，手动或后台程序添加titOnClassName类名（默认是'on'），相当于设置参数defaultIndex:1。若设置参数returnDefault:true，则鼠标移出.sideMen0.3秒可以返回当前频道 -->
        <ul>
            <li><a href="/shortcut/SearchNotes" target="right">查询单词</a></li>
            <li><a href="/shortcut/AddNotes" target="right">添加单词</a></li>
            <li><a href="/safe/queryAllNotes.html" target="right">词库</a></li>
        </ul>
        <h3 style="text-align: center;font-weight: 700"><em></em>用户信息维护</h3>
        <ul>
            <li><a href="/shortcut/UpdatePwd" target="right">修改密码</a></li>
        </ul>
    </div>

    <div class="div_right">
        <iframe scrolling="auto" rameborder="0"
                src="../../centercommon/rightmessage.jsp" name="right" width="100%"
                height="100%">

        </iframe>
    </div>

</div>

</body>
</html>
