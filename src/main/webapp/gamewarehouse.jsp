<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>游戏仓库</title>
        <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="js/xhdata.js"></script>
        <script type="text/javascript" src="js/jquery.pagination.js"></script>
        <script src="http://mockjs.com/dist/mock.js"></script>
        <link rel="stylesheet" type="text/css" href="css/gamewarehouse.css" />
        <link rel="stylesheet" type="text/css" href="css/pagination.css" />

    </head>
    <script type="text/javascript">
        //调用mock方法模拟数据
        Mock.mock(
            'http://mockjs', {
                "gameName" : '@name',     //模拟名称
                "image":'@image',          //模拟游戏图片
                "averageScore|1-10":10,    //模拟评分（1-10）
            }
        );

        //ajax请求
        $(function(){
            $.ajax({
                url        : "http://mockjs",    //请求的url地址
                dataType   : "json",   //返回格式为json
                async      : true, //请求是否异步，默认为异步，这也是ajax重要特性
                data       : {},    //参数值
                type       : "GET",   //请求方式
                beforeSend : function() {
                    //请求前的处理
                },
                success: function(req) {
                    //请求成功时处理
                    alert(req);
                    console.log(req);
                },
                complete: function() {
                    //请求完成的处理
                },
                error: function() {
                    //请求出错处理
                    alert("error!");
                }
            });
        });
    </script>
    <script>
        $(function () {
            $.ajax({
                url: 'http://127.0.0.1:8080/brpg/game',
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
    </script>
    <body>
        <div id="piclist">

        <ul id="listul">
        </ul>
            <div class="clear"></div>
            <div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
            <ul id="Searchresult" style="display:none;">
            </ul>

        </div>

    </body>
</html>
