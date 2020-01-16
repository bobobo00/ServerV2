package V2.Servlet;

import V2.Request;
import V2.Response;

/**
 * @ClassName RunServlet
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 14:56]
 * @Version 1.0
 **/

public class RunServlet extends HTTPServlet {
    @Override
    public void doGet(Request req, Response resp) {
        resp.println("Run");
    }
}
