package dao;

import javabean.Post;
import javabean.PostComment;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    private static QueryRunner qr = new QueryRunner(BaseDao.getDataSource());
    //读帖子列表（除内容、评论）
    public List<Object[]> readPostList(String type){
        List<Object[]> postList=new ArrayList<>();
        String sql = "SELECT Post_Id,Post_Title,User_Id FROM post where Post_Type=?";
        try {
            postList = qr.query( sql, new ArrayListHandler(),type);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return postList;
    }

    //读帖子详情(ALL)
    public Post readPostDetails(String postID){
        Post post=null;
        String sql = "select * from post where User_Id=?";
        try {
            post=qr.query(sql,new BeanHandler<Post>(Post.class), postID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    //写入评论
    public boolean writePostComment(String postID, PostComment postComment){
        String sql= "INSERT INTO post_comment (Post_Comment_Time, Post_Comment_Content, User_Id, Post_Id) VALUES (?,?,?,?)";
        try {
            Object[] params = {postComment.getTime(),postComment.getContent(),postComment.getCommentator(),postID};
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //写入帖子
    public boolean writePost(Post post){
        String sql= "INSERT INTO post (Post_Id, Post_Title, Post_Content, Post_Type, User_Id)VALUES (?,?,?,?,?)";
        try {
            Object[] params = {post.getPostID(),post.getTitle(),post.getContent(),post.getType(),post.getWriter()};
            qr.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
