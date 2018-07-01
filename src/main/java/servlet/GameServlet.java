package servlet;

import com.google.gson.Gson;
import dao.GameDao;
import javabean.Game;
import javabean.GameComment;
import javabean.GameCommentList;
import javabean.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 处理游戏相关的请求
 */
@WebServlet(name = "game", urlPatterns = "/game")
public class GameServlet extends BaseServlet {

    /**
     * 读游戏列表并返回json
     *
     * @param req
     * @param res 返回List<Game>对象的Json
     *
     * @throws Exception
     */
    public void getGameList(HttpServletRequest req, HttpServletResponse res) throws Exception {
        GameDao dao = new GameDao();
        List<Game> gameList = dao.readGameList();

        String gameListJson = gson.toJson(gameList);

        writeJsonToResponse(res, gameListJson);
    }

    /**
     * 读游戏列表并以评分高低排列
     *
     * @param req
     * @param res 返回List<Game>对象的Json
     *
     * @throws Exception
     */
    public void getGameListByOrder(HttpServletRequest req, HttpServletResponse res) throws Exception {
        GameDao dao = new GameDao();
        List<Game> gameList = dao.readGameList();
        Comparator<Game> comparator = (o1, o2) -> Float.compare(o2.getAverageScore(), o1.getAverageScore());
        gameList.sort(comparator);
        Gson gson = new Gson();
        String gameListJson = gson.toJson(gameList);
        writeJsonToResponse(res, gameListJson);
    }

    public void toGameInfo(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String gameID = req.getParameter("gameID");
        req.getSession().setAttribute("gameID", gameID);
        writeJsonToResponse(res, "1");
    }

    /**
     * 获取游戏详情
     *
     * @param req 参数：gameID
     * @param res 返回Game对象的Json
     *
     * @throws Exception
     */
    public void getGameInfo(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String gameID = (String) req.getSession().getAttribute("gameID");
        GameDao dao = new GameDao();
        Game game = dao.readGameDetails(gameID);
        GameCommentList gcl = new GameCommentList();
        gcl.setGameCommentList(dao.readComments(gameID));
        game.setGameCommentList(gcl);
        Gson gson = new Gson();
        String gameJson = gson.toJson(game);
        writeJsonToResponse(res, gameJson);
    }

    /**
     * 游戏评论
     *
     * @param req 参数：content,gameID
     * @param res 返回GameComment对象的Json
     *
     * @throws Exception
     */
    public void gameComment(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String gameID = req.getParameter("gameID");
        String content = req.getParameter("content");
        User user = (User) req.getSession().getAttribute("user");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = df.format(new Date());
        GameComment gameComment = new GameComment();
        gameComment.setUser(user);
        gameComment.setContent(content);
        gameComment.setTime(time);
        GameDao dao = new GameDao();
        if (dao.writeGameComment(gameID, gameComment, user.getUserID())) {
            //评论成功
            Gson gson = new Gson();
            String gameCommentJson = gson.toJson(gameComment);
            writeJsonToResponse(res, gameCommentJson);
        } else {
            //评论失败,返回0
            writeJsonToResponse(res, "0");
        }
    }
}
