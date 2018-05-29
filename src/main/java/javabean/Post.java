package javabean;

/**
 * 帖子类
 */
public class Post {
    protected String postID;//帖子ID
    protected User writer;//发帖用户
    protected String type;//帖子类型，新闻news,公告announcement,问答qa,攻略strategy,同人fanswork
    protected String title;//标题
    protected String content;//内容
    protected PostCommentList postCommentList;//帖子评论集

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostCommentList getPostCommentList() {
        return postCommentList;
    }

    public void setPostCommentList(PostCommentList postCommentList) {
        this.postCommentList = postCommentList;
    }
}
