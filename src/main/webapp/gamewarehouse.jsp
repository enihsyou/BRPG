<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>游戏仓库</title>
        <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
        <script src="http://mockjs.com/dist/mock.js"></script>
        <link rel="stylesheet" type="text/css" href="css/gamewarehouse.css" />
    </head>
    <!--<script>
        $(function () {
            $.ajax({
                url: 'game',
                type: 'GET',
                dataType: 'json',
                timeout: 1000,
                cache: false,
                beforeSend: LoadFunction, //加载执行方法
                error: erryFunction,  //错误执行方法
                success: succFunction //成功执行方法
            })
            function LoadFunction() {
                $("#list").html('加载中...');
            }
            function erryFunction() {
                alert("error");
            }
            function succFunction(data) {
                $("#list").html('');

                //eval将字符串转成对象数组
                //var json = { "id": "10086", "uname": "zhangsan", "email": "zhangsan@qq.com" };
                //json = eval(json);
                //alert("===json:id=" + json.id + ",uname=" + json.uname + ",email=" + json.email);

                var json = eval(data); //数组
                $.each(json, function (index, item) {
                    //循环获取数据
                    var gameName = json[index].gameName;//游戏名字
                    var image = json[index].image;//游戏图片
                    var averageScore = json[index].averageScore;//游戏评分
                    $("#listul").html($("#listul").html() + "<br>" + gameName + " - " + image + " - " + averageScore + "<br/>");
                });
            }
        });
    </script>  -->
    <body>
        <frameset id="container">
            <frame id="header" src="header.html">
            <frame id="gamelist" src="#">
            <frame id="footer" src="footer.html">
        <!--<div id="piclist">

        <ul id="listul">
        </ul>
        <div class="fydiv">
            <ul class="fenye"></ul>
        </div>  -->


        </frameset>
    </body>
</html>