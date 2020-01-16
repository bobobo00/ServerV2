package V2.Servlet;

import V2.Request;
import V2.Response;

/**
 * @ClassName PlainTextServlet
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 14:52]
 * @Version 1.0
 **/

public class PlainTextServlet extends HTTPServlet {
    @Override
    public void doGet(Request req, Response resp) {
        resp.setHeaders("Content-Type","text/plain;charset=utf-8");
        resp.println("<h1>我不是html元素</h1>");
    }
}
