package javabean;

/**
 * 游戏类
 */
public class Game {
    private String gameID;//游戏ID
    private String gameName;//游戏名
    private String synopsis;//简介
    private String image;//图片路径
    private float averageScore;//游戏评分（综合）
    private GameCommentList gameCommentList;//游戏评论集
    private GameScoreList gameScoreList;//游戏评分集（每一个用户的评分）


    public GameScoreList getGameScoreList() {
        return gameScoreList;
    }

    public void setGameScoreList(GameScoreList gameScoreList) {
        this.gameScoreList = gameScoreList;
    }



    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    public GameCommentList getGameCommentList() {
        return gameCommentList;
    }

    public void setGameCommentList(GameCommentList gameCommentList) {
        this.gameCommentList = gameCommentList;
    }
}
