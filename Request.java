package V2;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Request
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 9:58]
 * @Version 1.0
 **/

public class Request {
    private String method;//方法
    private String  path;//路径
    private String version;//版本
    Map<String,String> header=new HashMap<>();
    Map<String,String> parseURL=new HashMap<>();

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getParseURL() {
        return parseURL;
    }

    public Map<String, String> getHeader() {

        return header;
    }

    static Request parse(InputStream is) throws UnsupportedEncodingException {
        Request request=new Request();
        Scanner scanner=new Scanner(is,"utf-8");
        String line=scanner.nextLine();
        String[] group=line.split(" ");
        request.method=group[0];
        parsepath(group[1],request);
        request.version=group[2];
        String message;
        while(!(message=scanner.nextLine()).isEmpty()){
            String[] datas=message.split(":");
            request.header.put(datas[0].trim(),datas[1].trim());
        }
        print(request);
        return request;
    }

    private static void print(Request request) {
        if(request!=null){
            System.out.println("方法："+request.method);
            System.out.println("路径："+request.path);
            System.out.println("版本："+request.version);
            System.out.print("URL：");
            if(!(request.parseURL.isEmpty())){
                for(Map.Entry<String,String> entry:request.parseURL.entrySet()){
                    System.out.println(entry.getKey()+"="+entry.getValue());
                }
            }
            else{System.out.println();}
        }
    }

    private static void parsepath(String s,Request request) throws UnsupportedEncodingException {
        String[] str=s.split("\\?");
        request.path=URLDecoder.decode(str[0],"UTF-8");
        if(str.length==2){
            String[] message=str[1].split("&");
            for(String ss:message){
                ss=URLDecoder.decode(ss,"UTF-8");
                String[] kv=ss.split("=");
                if(kv.length<2){
                    request.parseURL.put(kv[0],null);
                }else{
                request.parseURL.put(kv[0],kv[1]);
                }
            }
        }
    }

}
