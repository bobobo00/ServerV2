package V2.Servlet;

import V2.Request;
import V2.Response;
import V2.SessionServer;
import V2.business.User;

import java.io.IOException;

/**
 * @ClassName LoginServlet
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 15:41]
 * @Version 1.0
 **/

public class LoginServlet extends HTTPServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        String username=req.getParseURL().get("username");
        if(username==null){
            resp.setStauts("401 Unauthorized");
            resp.println("<h1>请登录</h1>");
            return;
        }
        User currentUser= User.findUser(username);
        if(currentUser==null){
            resp.setStauts("401 Unauthorized");
            resp.println("<h1>该用户不存在</h1>");
            return;
        }
        String sessionid=SessionServer.put(currentUser);
        resp.setHeaders("Set-Cookie","sessionid="+sessionid+"; expires=Tue, 07-Apr-2020 08:46:16 GMT; Max-Age=8640000");
        resp.println("<h1>欢迎"+username+"光临</h1>");
    }
}
