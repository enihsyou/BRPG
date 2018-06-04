package servlet;

import com.google.gson.Gson;
import javabean.Game;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StupidServlet",urlPatterns = "/lalala")
public class StupidServlet extends BaseServlet {
    /**
     * 读取注册人数，在线人数，游戏人数
     * @param req
     * @param res 返回数据为String[]的Json串
     * @throws Exception
     */
    public void getNum(HttpServletRequest req, HttpServletResponse res)throws Exception{
        String[] arr={"20","10","8"};
        Gson gson=new Gson();
        String arrJson=gson.toJson(arr);
        res.getWriter().write(arrJson);
    }

    /**
     * 读取游戏列表
     * @param req
     * @param res 返回数据为List<Game>的Json串
     * @throws Exception
     */
    public void getList(HttpServletRequest req,HttpServletResponse res)throws Exception{
        List<Game> gameList=new ArrayList<>();
        for (int i=0;i<10;i++){
            Game gameA=new Game();
            gameA.setGameName("game"+i);
            gameA.setAverageScore(Float.parseFloat("2.2"));
            gameA.setImage("https://www.baidu.com/img/bd_logo1.png?where=super");
            gameList.add(gameA);
        }
        Gson gson=new Gson();
        String json=gson.toJson(gameList);
        res.getWriter().write(json);
    }
}
