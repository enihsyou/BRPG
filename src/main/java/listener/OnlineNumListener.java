package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听在线人数，onlineNum属性存储在context中
 */
@WebListener
public class OnlineNumListener implements HttpSessionListener {
    private int onlineNum;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        onlineNum++;
        se.getSession().getServletContext().setAttribute("onlineNum",onlineNum);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        onlineNum--;
        se.getSession().getServletContext().setAttribute("onlineNum",onlineNum);
    }
}
