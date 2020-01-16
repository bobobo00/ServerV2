package V2;


import V2.Servlet.*;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName Task
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 9:41]
 * @Version 1.0
 **/

public class Task implements Runnable {
    private Socket client;
    Mapping mapping=new Mapping();
    public Task(Socket client){
        this.client=client;
    }
    private void initial(Mapping mapping){
        mapping.putMapping("/joke.js","V2.Servlet.JokeJSServlet");
        mapping.putMapping("/hello","V2.Servlet.HelloServlet");
        mapping.putMapping("/plain","V2.Servlet.PlainTextServlet");
        mapping.putMapping("/redirect","V2.Servlet.RedirectServlet");
        mapping.putMapping("/run","V2.Servlet.RunServlet");
        mapping.putMapping("/login","V2.Servlet.LoginServlet");
    }
    public void run(){
        initial(this.mapping);
        try{
            InputStream is=client.getInputStream();
            OutputStream os=client.getOutputStream();
            Request request=Request.parse(is);
            Response response=new Response();
            response.setHeaders("Content-Type","text/html;charset=utf-8");
            HTTPServlet servlet=mapping.getclz(request.getPath());
            if(servlet==null){
                String filename="docbase"+request.getPath();
                File file=new File(filename);
                if(!file.exists()){
                servlet=new NotFoundServlet();
                }else{
                    servlet=new StaticServlet();
                }
            }
            servlet.doGet(request,response);
            response.writeAndFlush(os);
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
