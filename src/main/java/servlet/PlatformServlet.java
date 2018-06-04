package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理平台相关请求
 */
@WebServlet(name = "platform",urlPatterns = "/platform")
public class PlatformServlet extends BaseServlet{
    /**
     * 获取在线人数
     * @param req
     * @param res 返回String类型
     * @throws Exception
     */
    public void getOnlineNum(HttpServletRequest req, HttpServletResponse res)throws Exception{
        String onlineNum= (String) req.getSession().getServletContext().getAttribute("onlineNum");
        res.getWriter().write(onlineNum);
    }
}
