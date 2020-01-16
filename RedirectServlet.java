package V2.Servlet;

import V2.Request;
import V2.Response;

/**
 * @ClassName RedirectServlet
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 14:54]
 * @Version 1.0
 **/

public class RedirectServlet extends HTTPServlet {
    @Override
    public void doGet(Request req, Response resp) {
        resp.setStauts("307 Temporary Redirect");
        resp.setHeaders("Location","www.baidu.com");
    }
}
