package javabean;

import java.util.List;

/**
 * 帖子评论集合类
 */
public class PostCommentList {
    private List<PostComment> postCommentList;//帖子评论集合

    public List<PostComment> getPostCommentList() {
        return postCommentList;
    }

    public void setPostCommentList(List<PostComment> postCommentList) {
        this.postCommentList = postCommentList;
    }
}
