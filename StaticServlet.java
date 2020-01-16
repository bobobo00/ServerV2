package V2.Servlet;

import V2.Request;
import V2.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @ClassName StaticServlet
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 16:10]
 * @Version 1.0
 **/

public class StaticServlet extends HTTPServlet{
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        int index=req.getPath().lastIndexOf('.');
        String suffix=req.getPath().substring(index+1);
        if(suffix.equals("css")){
            resp.setHeaders("Content-Type","text/css,charset=UTF-8");
        }
        String filename="docbase"+req.getPath();
        try{
            InputStream is=new FileInputStream(filename);
            Scanner scanner=new Scanner(is,"UTF-8");
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                resp.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
