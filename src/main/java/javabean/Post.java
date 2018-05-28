package javabean;

public class Post {
    protected String postID;
    protected User writer;
    protected String type;
    protected String title;
    protected String content;
    protected PostCommentList postCommentList;

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
