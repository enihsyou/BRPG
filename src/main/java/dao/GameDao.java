package dao;

import javabean.Game;
import javabean.GameComment;
import javabean.GameScore;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDao {
    private static QueryRunner qr = new QueryRunner(BaseDao.getDataSource());
    //读游戏列表（id、name、image、少scorelist）
    public List<Object[]> readGameList(){
         List<Object[]> gameList = new ArrayList<>();
        String sql="select Game_Id,Game_Image,Game_Name from game";
        try {
            gameList = qr.query(sql,new ArrayListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gameList;
    }

    //读游戏详情
    public Game readGameDetails(String gameID) {
        Game game=null;
        String sql= "select * from game where Game_Id = ?";
        try {
            game=qr.query(sql,new BeanHandler<Game>(Game.class), Integer.parseInt(gameID));
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return game;
    }

        //写入评分
    public boolean writeGameScore(String gameID,String userID,GameScore gameScore) {
        String sql="insert into game_grade values(?,?,?)";
        try {
            Object[] params = {gameScore.getScore(),userID,gameID};
            qr.update(sql,params);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    //写入评论
    public boolean writeGameComment(String gameID, GameComment gameComment,String userID) {
        String sql = "insert into game_comment values(?,?,?,?)";
        try {
            Object[] params = {gameComment.getTime(),gameComment.getContent(),userID,gameID};
            qr.update(sql,params);
            //System.out.println(row);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
