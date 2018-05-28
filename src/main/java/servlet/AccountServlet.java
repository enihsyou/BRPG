package servlet;

import javabean.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "account",urlPatterns = "/account")
public class AccountServlet extends BaseServlet{
    /**
     * 用户登录,method=login
     * @param req 参数：账号userID,密码password
     * @param res
     * @throws Exception
     */
    public void login(HttpServletRequest req, HttpServletResponse res)throws Exception{
        String userID=req.getParameter("userID");
        String password=req.getParameter("password");
        User user=new User();
        if (user.login(userID,password)){
            //登录成功,将user存入session
        }else {
            //登录失败
        }
    }
}
