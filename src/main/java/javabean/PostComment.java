package javabean;

/**
 * 帖子评论类
 */
public class PostComment {
    private User commentator;//评论人
    private String content;//评论内容
    private String time;//评论时间

    public User getCommentator() {
        return commentator;
    }

    public void setCommentator(User commentator) {
        this.commentator = commentator;
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
