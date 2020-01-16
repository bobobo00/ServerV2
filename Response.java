package V2;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Response
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 10:22]
 * @Version 1.0
 **/

public class Response {
    String stauts;//状态
    Map<String,String> headers=new HashMap<>();
    StringBuilder body=new StringBuilder();

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    public void setHeaders(String key,String value) {
        this.headers.put(key,value);
    }

    public void print(String s){
        body.append(s);
    }

    public void println(String s){
        body.append(s).append("\r\n");
    }
    public void writeAndFlush(OutputStream os) throws Exception {
        //组装response
        StringBuilder responseBuilder=new StringBuilder();
        //组装状态行
        responseBuilder.append("HTTP/1.0 ");
        responseBuilder.append(stauts).append("\r\n");
        //组装响应头
        if(body.length()!=0){
            int contentLength=body.toString().getBytes("UTF-8").length;
            setHeaders("Content-Length",String.valueOf(contentLength));
        }
        for(Map.Entry<String,String> entry:headers.entrySet()){
            responseBuilder.append(entry.getKey()).append(":").append(entry.getValue());
            responseBuilder.append("\r\n");
        }
        responseBuilder.append("\r\n");
        responseBuilder.append(body);
        os.write(responseBuilder.toString().getBytes("UTF-8"));
        os.flush();

    }
}
