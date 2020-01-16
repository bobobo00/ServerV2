package V2.Servlet;

import V2.Request;
import V2.Response;

/**
 * @ClassName NotFoundServlet
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 14:50]
 * @Version 1.0
 **/

public class NotFoundServlet extends HTTPServlet{
    @Override
    public void doGet(Request req, Response resp) {
        resp.setStauts("404 NOT FOUND");
        resp.println("<h1>页面不存在</h1>");
    }
}
