package javabean;

/**
 * 被举报帖子
 */
public class ReportedPost extends Post{
    private User reporter;//举报人
    private String time;//举报时间

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
