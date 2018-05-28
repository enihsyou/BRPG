package javabean;

public class Game {
    private String gameID;
    private String gameName;
    private String synopsis;
    private String image;
    private float averageScore;
    private GameCommentList gameCommentList;

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
