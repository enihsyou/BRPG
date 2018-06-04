<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>游戏仓库</title>
        <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="js/xhdata.js"></script>
        <script type="text/javascript" src="js/jquery.pagination.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <script src="http://mockjs.com/dist/mock.js"></script>
        <link rel="stylesheet" type="text/css" href="css/gamewarehouse.css" />
        <link rel="stylesheet" type="text/css" href="css/pagination.css" />
        <link rel="stylesheet" type="text/css" href="css/grade.css" />
        <link rel="stylesheet" type="text/css" href="css/gamelist.css" />

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
                    console.log(req);
                    //打印json中的value
                    /*$.each(req, function(i) {
                        document.writeln(req[i] + '<br>');
                    }); */

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

    <div id="cen_right_top" class="btndiv">
        <h3 class="active">默认</h3>
        <h3 >按评分</h3>
        <div class="mainleft2 btndiv" style="display:block">
            <dl>
                <dt>迷失岛<span>评分：9分</span></dt>
                <dd class="dd0"><a href="#"><img src="assets/img1.jpg" alt="为雅安同胞祈祷"></a></dd>
                <dd class="dd1">>亲爱的玩家朋友：停机更新工作已进行完毕，我们将提前开启服务器，欢迎大家参与游戏体验。感谢大家对我们游戏的支持与喜爱！</dd>
                <dd class="dd2"><a href="#">查看详情</a></dd>
            </dl>
            <dl>
                <dt>猫忍之心<span>评分：7分</span></dt>
                <dd class="dd0"><a href="#"><img src="assets/img2.jpg" alt="更新提前"></a></dd>
                <dd class="dd1">亲爱的玩家朋友：停机更新工作已进行完毕，我们将提前开启服务器，欢迎大家参与游戏体验。感谢大家对我们游戏的支持与喜爱！</dd>
                <dd class="dd2"><a href="#">查看详情</a></dd>
            </dl>
            <dl>
                <dt>嗜血代码<span>评分：9分</span></dt>
                <dd class="dd0"><a href="#"><img src="assets/i2.jpg" alt="支援灾区"></a></dd>
                <dd class="dd1">>亲爱的玩家朋友：停机更新工作已进行完毕，我们将提前开启服务器，欢迎大家参与游戏体验。感谢大家对我们游戏的支持与喜爱！</dd>
                <dd class="dd2"><a href="#">查看详情</a></dd>
            </dl>
            <dl>
                <dt>穷追不舍<span>评分：9分</span></dt>
                <dd class="dd0"><a href="#"><img src="assets/1368022916_1719592020_22615_imageAddr.jpg" alt="停机更新"></a></dd>
                <dd class="dd1">>亲爱的玩家朋友：停机更新工作已进行完毕，我们将提前开启服务器，欢迎大家参与游戏体验。感谢大家对我们游戏的支持与喜爱！</dd>
                <dd class="dd2"><a href="#">查看详情</a></dd>
            </dl>
            <dl>
                <dt>杀手谜题<span>评分：8分</span></dt>
                <dd class="dd0"><a href="#"><img src="assets/1367250767_1719592020_345_imageAddr.jpg" alt="测试延期"></a></dd>
                <dd class="dd1">>亲爱的玩家朋友：停机更新工作已进行完毕，我们将提前开启服务器，欢迎大家参与游戏体验。感谢大家对我们游戏的支持与喜爱！</dd>
                <dd class="dd2"><a href="#">查看详情</a></dd>
            </dl>
        </div>
        <div class="btndiv">
            按评分的内容
        </div>
    </div>
    <br/><br><br>
    <div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
    <ul id="Searchresult" style="display:none;">
    </ul>

    <!--<div style="display:block">默认的内容</div>
        <div>按评分的内容</div>
    </div>  -->

    <!--<div id="piclist">

        <ul id="listul">
        </ul>
            <div class="clear"></div>
            <div id="Pagination" class="pagination"><!-- 这里显示分页 -->
           <!-- <ul id="Searchresult" style="display:none;">
            </ul>

        </div> -->

    </body>
</html>
