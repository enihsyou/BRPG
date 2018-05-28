package dao;

import javabean.Game;
import javabean.GameComment;
import javabean.GameScore;

import java.util.List;

public class GameDao extends BaseDao {
    //读游戏列表（id、name、image、scorelist）
    public List<Game> readGameList(){   return  null;}

    //读游戏详情(ALL)
    public Game readGameDetails(String gameID){return null;}

    //写入评分
    public boolean writeGameScore(String gameID, GameScore gameScore) { return true;}

    //写入评论
    public boolean writeGameComment(String gameID, GameComment gameComment){return true;}


}
