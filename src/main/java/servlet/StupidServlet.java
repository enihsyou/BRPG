package servlet;

import com.google.gson.Gson;
import javabean.Game;
import javabean.GameComment;
import javabean.GameCommentList;
import javabean.User;

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

    /**
     * 读取游戏详情
     * @param req
     * @param res 返回数据为Game对象的Json串
     * @throws Exception
     */
    public void getGameInfo(HttpServletRequest req,HttpServletResponse res)throws Exception{
        Game game=new Game();
        game.setGameID("10001");
        game.setGameName("嘻嘻哈哈");
        game.setSynopsis("我是一个小朋友小呀小朋友，今年二十又七八又呀又七八");
        game.setImage("https://cdn.steamstatic.com.8686c.com/steam/apps/846470/capsule_184x69.jpg?t=1528390713");
        game.setAverageScore(Float.parseFloat("4.5"));
        GameCommentList gameCommentList=new GameCommentList();
        List<GameComment> gameComments=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            GameComment gameComment=new GameComment();
            gameComment.setContent("今天天气好");
            gameComment.setTime("2018-08-29 15:28");
            User user=new User();
            user.setUserName("NameBob"+i);
            gameComment.setUser(user);
            gameComments.add(gameComment);
        }
        gameCommentList.setGameCommentList(gameComments);
        game.setGameCommentList(gameCommentList);
        Gson gson=new Gson();
        String json=gson.toJson(game);
        res.getWriter().write(json);
    }
}
