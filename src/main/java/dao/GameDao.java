package dao;

import javabean.Game;
import javabean.GameComment;
import javabean.GameScore;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDao {
    private static QueryRunner qr = new QueryRunner(BaseDao.getDataSource());
    //读游戏列表（id、name、image、缺scorelist）
    public List<Game> readGameList(){
        List<Game> gameList=new ArrayList<>();
        String sql="SELECT * FROM v_game;";
        try (
                Connection conn = BaseDao.getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)
        ){

            try(
                    ResultSet resultSet=pstmt.executeQuery()
            ){
                while (resultSet.next()){
                    Game game=new Game();
                    game.setGameID(Integer.toString(resultSet.getInt("Game_Id")));
                    game.setImage(resultSet.getString("Game_Image"));
                    game.setSynopsis(resultSet.getString("Game_Synopsis"));
                    game.setGameName(resultSet.getString("Game_Name"));
                    game.setAverageScore(resultSet.getFloat("score"));
                    gameList.add(game);
                }
                resultSet.close();
                pstmt.close();
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        /*List<Game> gameList = new ArrayList<Game>();
        String sql="select Game_Id,Game_Image,Game_Name from game";
        try {
            gameList=(List<Game>) qr.query(sql,new BeanListHandler<Game>(Game.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return gameList;
    }

    //读游戏详情
    public Game readGameDetails(String gameID) {
        Game game=new Game();
        String sql= "select * from v_game where Game_Id = ?";
        try (
                Connection conn = BaseDao.getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)
        ){
            pstmt.setString(1,gameID);

            try(

                    ResultSet resultSet=pstmt.executeQuery()
            ){
                if (resultSet.next()){
                    game.setGameID(gameID);
                    game.setImage(resultSet.getString("Game_Image"));
                    game.setSynopsis(resultSet.getString("Game_Synopsis"));
                    game.setGameName(resultSet.getString("Game_Name"));
                    game.setAverageScore(resultSet.getFloat("score"));
                }
                resultSet.close();
                pstmt.close();
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return game;
    }

    public List<GameComment> readComments(String gameID){
        List<GameComment> commentList=new ArrayList<>();
        String sql="SELECT * FROM game_comment where Game_Id = ?";
        try (
                Connection conn = BaseDao.getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)
        ){
            pstmt.setString(1,gameID);

            try(
                    ResultSet resultSet=pstmt.executeQuery()
            ){
                while (resultSet.next()){
                    GameComment cmt=new GameComment();
                    cmt.setContent(resultSet.getString("Game_Comment_Content"));
                    cmt.setTime(resultSet.getString("Game_Comment_Time"));
                    AccountDao accountDao=new AccountDao();
                    cmt.setUser(accountDao.readAccount(resultSet.getString("User_Id")));
                    commentList.add(cmt);
                }
                resultSet.close();
                pstmt.close();
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return commentList;
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
