package servlet;

import com.google.gson.Gson;
import dao.PostDao;
import javabean.Post;
import javabean.PostComment;
import javabean.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 处理帖子相关的请求
 */
@WebServlet(name = "post",urlPatterns = "/post")
public class PostServlet extends BaseServlet {

    /**
     * 按类型获取帖子列表
     * @param req 参数:type
     * @param res
     * @throws Exception
     */
    public void getPostList(HttpServletRequest req, HttpServletResponse res)throws Exception{
        String type=req.getParameter("type");
        PostDao dao=new PostDao();
        List<Post> postList=dao.readPostList(type);
        Gson gson=new Gson();
        String postListJson=gson.toJson(postList);
        res.setContentType("text/html;utf-8");
        res.getWriter().write(postListJson);
    }

    /**
     * 读帖子详情
     * @param req 参数:postID
     * @param res
     * @throws Exception
     */
    public void getPostInfo(HttpServletRequest req,HttpServletResponse res)throws Exception{
        String postID=req.getParameter("postID");
        PostDao dao=new PostDao();
        Post post=dao.readPostDetails(postID);
        Gson gson=new Gson();
        String postJson=gson.toJson(post);
        res.setContentType("text/html;utf-8");
        res.getWriter().write(postJson);
    }

    /**
     * 发表帖子
     * @param req 参数：type,title,content
     * @param res
     * @throws Exception
     */
    public void writePost(HttpServletRequest req,HttpServletResponse res)throws Exception{
        User writer= (User) req.getSession().getAttribute("user");
        String type=req.getParameter("type");
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        Post post=new Post();
        post.setWriter(writer);
        post.setContent(content);
        post.setTitle(title);
        post.setType(type);
        PostDao dao=new PostDao();
        Post newPost=null;
        if ((newPost=dao.writePost(post))!=null){
            req.getSession().setAttribute("newPost",newPost);
            //TODO 跳转新帖子页面,可能有误，待改
        }else {
            //TODO 提示错误信息
        }
    }

    /**
     * 帖子评论
     * @param req 参数：content,postID
     * @param res
     * @throws Exception
     */
    public void postComment(HttpServletRequest req,HttpServletResponse res)throws Exception{
        String content=req.getParameter("content");
        String postID=req.getParameter("postID");
        User commentator= (User) req.getSession().getAttribute("user");
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time=df.format(new Date());
        PostComment postComment=new PostComment();
        postComment.setCommentator(commentator);
        postComment.setContent(content);
        postComment.setTime(time);
        PostDao dao=new PostDao();
        if (dao.writePostComment(postID,postComment)){
            //评论成功则返回评论对象
            Gson gson=new Gson();
            String postCommentJson=gson.toJson(postComment);
            res.setContentType("text/html;utf-8");
            res.getWriter().write(postCommentJson);
        }else {
            res.getWriter().write("0");
        }
    }

}
