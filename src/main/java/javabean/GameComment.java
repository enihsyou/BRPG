package javabean;

/**
 * 游戏评论类
 */
public class GameComment {
    private User user;//评论游戏的用户
    private String content;//评论内容
    private String time;//评论时间

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
