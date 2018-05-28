package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 界面辅助类，跳转前获取信息
 */

@WebServlet(name = "surfaceHelper",urlPatterns = "/surface")
public class SurfaceHelper extends BaseServlet{
    /**
     * 读游戏列表并跳转到游戏仓库
     * @param req
     * @param res
     * @throws Exception
     */
    public void toGameDepository(HttpServletRequest req, HttpServletResponse res)throws Exception{

    }
}
