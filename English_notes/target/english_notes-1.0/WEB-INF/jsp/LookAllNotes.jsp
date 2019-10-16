<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
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
    <script language="JavaScript" src="../../js/lib/jquery.min.1.11.3.js"></script>
    <script src="../../js/lib/jquery.js"></script>
    <!-- 输入合法性的验证 -->
    <script src="../../js/pintuer.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".modify").click(function () {
                $(this).hide();
                $(this).parent().next().children("a").hide();
                $(this).parent().parent().find("span").hide();
                $(this).parent().parent().find("input").show();
            });
            $(".cancel").click(function () {
                $(this).prev().show();
                $(this).parent().prev().children("button").show();
                $(this).parent().parent().find("span").show();
                $(this).parent().parent().find("input").hide();
            });
            $(".define").click(function () {
                var wordid = $(this).prev().val();
                var wordNew = $(this).parent().prev().prev().prev().children("input").val();
                var notesNew = $(this).parent().prev().prev().children("input").val();
                $.ajax({
                    url: '/safe/updateNotes.html',
                    type: 'POST', //method  get post
                    async: true,    //或false,是否异步
                    data: {
                        wordid: wordid,  // key-value的数据
                        wordNew: wordNew,
                        notesNew: notesNew
                    },
                    timeout: 15000,    //超时时间
                    dataType: 'json',  //响应返回的数据格式

                    success: function (data) {
                        alert(data.resultInfo);
                        window.location.reload();
                    },

                    error: function (e) {
                        var rt = window.confirm("返回数据异常");
                        if(rt) {
                            window.location.reload();
                        }
                    }

                });
            })
        })

    </script>
    <style>
        td a, button {
            border-radius: 3px;
            border: 1px solid #dfdfdf;
            background: white;
            display: inline-block;
            padding: 5px 12px;
        }

        td a:hover, button:hover {
            background: #09F;
            color: #FFF;
            border-color: #09F;
        }

        .define, .cancel {
            border-radius: 3px;
            border: 1px solid #dfdfdf;
            background: red;
            color: white;
            display: inline-block;
            padding: 5px 12px;
        }

        /*.define:hover,.cancel:hover{*/
        /*!*background: #09F;*!*/
        /*color: #FFF;*/
        /*border-color: #09F;*/
        /*}*/

    </style>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head">
        <strong> 内容列表</strong>
        <span id="msg" style="margin-left: 60px; color: #ff0000;">${resultInfo}</span>
    </div>
    <%--<form id="login" method="get">--%>
    <table class="table table-hover text-center">
        <tr>
            <th>单词</th>
            <th>解释</th>
            <th width="400px">修改时间</th>
            <th width="110px"></th>
            <th width="110px"></th>
        </tr>
        <c:if test="${notes.size()>0}">
            <c:forEach items="${notes}" var="note" varStatus="vs">
                <tr>
                    <td style="color:red"><span>${note.word}</span>
                        <input style="display: none" name="word" class="modifyBox" value="${note.word}"/>
                    </td>
                    <td><span>${note.notes}</span>
                        <input style="display: none" name="notes" class="modifyBox" value="${note.notes}"/>
                    </td>
                    <td>${note.updateDate}</td>
                    <td>
                        <button class="modify">修改</button>
                        <input type="hidden" name="wordid" value="${note.wordid}"/>
                        <input class="define" type="submit" style="display: none" value="确定">
                    </td>
                    <td>
                        <a href="/safe/deleteNotes.html?wordid=${note.wordid}&pageNow=${pageNow}">删除</a>
                        <input class="cancel" type="button" style="display: none" value="取消">
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <%--</form>--%>


    <%--分页查询--%>
    <div>
        <div class="pagelist">
            <c:choose>
                <c:when test="${notes.size()>0}">
                    <c:choose>
                        <c:when test="${pageNow>1}">
                            <a href="/safe/queryAllNotes.html?pageNow=${pageNow-1}">上一页</a>
                        </c:when>
                        <c:otherwise>
                            <span class="current">上一页</span>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach begin="1" end="${totalPage}" var="i">
                        <c:choose>
                            <c:when test="${i==pageNow}">
                                <span class="current">${i}</span>
                            </c:when>
                            <c:otherwise>
                                <a href="/safe/queryAllNotes.html?pageNow=${i}">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${pageNow<totalPage}">
                            <a href="/safe/queryAllNotes.html?pageNow=${pageNow+1}">下一页</a>
                            <a href="/safe/queryAllNotes.html?pageNow=${totalPage}">尾页</a>
                        </c:when>
                        <c:otherwise>
                            <span class="current">下一页</span>
                            <span class="current">尾页</span>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <span class="current">上一页</span> <span class="current">1</span>
                    <span class="current">下一页</span><span class="current">尾页</span>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

</div>
</body>
</html>