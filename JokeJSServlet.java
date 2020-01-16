package V2.Servlet;

import V2.Request;
import V2.Response;
import V2.Servlet.HTTPServlet;

/**
 * @ClassName JokeJSServlet
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 10:45]
 * @Version 1.0
 **/

public class JokeJSServlet extends HTTPServlet {
    @Override
    public void doGet(Request req, Response resp) {
        resp.setStauts("200 OK");
        resp.setHeaders("Content-Type","application/javascript;charset=utf-8");
        resp.println("很好！OK");
    }
}
