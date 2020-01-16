package V2.Servlet;

import V2.Request;
import V2.Response;

import java.io.IOException;

/**
 * @ClassName HTTPServlet
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 10:43]
 * @Version 1.0
 **/

public abstract class HTTPServlet {
    public abstract void doGet(Request req, Response resp) throws IOException;
}
