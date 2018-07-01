package servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    protected final Gson gson = new Gson();

    protected static void writeJsonToResponse(HttpServletResponse response, String jsonString) {
        try (PrintWriter writer = response.getWriter()) {
            response.setContentType("application/json;charset=utf-8");
            writer.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            Class clazz = this.getClass();
            String methodName = req.getParameter("method");
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            final HttpServletRequest httpRequest = (HttpServletRequest) req;
            final HttpServletResponse httpResponse = (HttpServletResponse) res;
            method.invoke(this, httpRequest, httpResponse);
            httpResponse.addHeader("Access-Control-Allow-Origin", "*");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
