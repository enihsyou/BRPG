package servlet;

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StupidServlet",urlPatterns = "/lalala")
public class StupidServlet extends BaseServlet {
    /**
     * 读取注册人数，在线人数，游戏人数
     * @param req
     * @param res 返回数据为String[]的Json串
     * @throws Exception
     */
    public void getNum(HttpServletRequest req, HttpServletResponse res)throws Exception{
        String[] arr={"20","10","8"};
        Gson gson=new Gson();
        String arrJson=gson.toJson(arr);
        res.getWriter().write(arrJson);
    }
}
