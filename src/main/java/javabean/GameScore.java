package javabean;

/**
 * 游戏评分类（单个用户评分）
 */
public class GameScore {
    private User user;//评分的用户
    private int score;//评分1，2,3,4,5

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
