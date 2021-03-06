package servlet;

import dao.AccountDao;
import javabean.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理用户账户有关的请求，需要传入method参数执行对应的方法
 */
@WebServlet(name = "account", urlPatterns = "/account")
public class AccountServlet extends BaseServlet {

    /**
     * 用户登录,method=login
     *
     * @param req 参数：账号userID,密码password
     * @param res
     * @throws Exception
     */
    public void login(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String userID = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = new User();
        if (user.login(userID, password)) {
            //登录成功,将user存入session
            req.getSession().setAttribute("user", user);
            final String s = gson.toJson(user);
            writeJsonToResponse(res, s);
        } else {
            //登录失败
            writeJsonToResponse(res, "0");
        }
    }

    /**
     * 用户注册,method=register
     *
     * @param req 参数：userID,password,userName
     * @param res
     * @throws Exception
     */
    public void register(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String userID = req.getParameter("userId");
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");
        User user = new User();
        if (user.register(userID, password, userName)) {
            //注册成功
            req.getSession().setAttribute("user", user);
            final String s = gson.toJson(user);
            writeJsonToResponse(res, s);
        } else {
            //注册失败
            writeJsonToResponse(res, "0");
        }
    }

    /**
     * 修改个人信息,method=changeInfo
     *
     * @param req 参数：userName,signature
     * @param res
     * @throws Exception
     */
    public void changeInfo(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String userName = req.getParameter("userName");
        String signature = req.getParameter("signature");
        User user = (User) req.getSession().getAttribute("user");
        if (user.changeInfo(userName, signature)) {
            //修改成功，存入session,返回到界面
            req.getSession().setAttribute("user", user);
        } else {
            //修改失败
            writeJsonToResponse(res, "0");
        }
    }

    /**
     * 修改密码，method=changePw
     *
     * @param req 参数：password
     * @param res
     * @throws Exception
     */
    public void changePw(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String password = req.getParameter("password");
        User user = (User) req.getSession().getAttribute("user");
        if (user.changePw(password)) {
            //修改成功，存入session
            req.getSession().setAttribute("user", user);
        } else {
            //修改失败
            writeJsonToResponse(res, "0");
        }
    }

    /**
     * 收藏游戏
     *
     * @param req 参数：gameID
     * @param res 返回1表示操作成功，返回0表示操作失败
     * @throws Exception
     */
    public void setCollection(HttpServletRequest req, HttpServletResponse res) throws Exception {
        User user = (User) req.getSession().getAttribute("user");
        String gameID = req.getParameter("gameID");
        AccountDao dao = new AccountDao();
        if (dao.setCollection(user.getUserID(), gameID)) {
            //收藏成功
            writeJsonToResponse(res, "1");
        } else {
            //收藏失败
            writeJsonToResponse(res, "0");
        }
    }
}
