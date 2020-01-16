package V2.Servlet;

import V2.Request;
import V2.Response;
import V2.SessionServer;
import V2.business.User;

import java.io.IOException;

/**
 * @ClassName HelloServlet
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 14:47]
 * @Version 1.0
 **/

public class HelloServlet extends HTTPServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        String sessionid=null;
        String cookie=req.getHeader().get("Cookie");
        if(cookie!=null){
            sessionid=cookie.split("=")[1];
        }
        User user=SessionServer.get(sessionid);
        resp.setHeaders("Content-Type","text/plain;charset=utf-8");
        resp.println("当前用户是："+user.username);
        resp.println("账户余额为："+user.balance);
    }
}
