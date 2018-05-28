package dao;

import javabean.GameComment;
import javabean.Post;
import javabean.PostComment;

public class PostDao extends BaseDao {
    //读帖子列表（除了内容、评论）
    public List<Post> readPostList(String type){return null;}

    //读帖子详情(ALL)
    public Post readPostDetails(String postID){return null;}

    //写入评论
    public boolean writePostComment(String postID, PostComment postComment){return true;}

    //写入帖子
    public Post writePost(Post post){return null;}

}
