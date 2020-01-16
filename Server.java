package V2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Server
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 9:37]
 * @Version 1.0
 **/

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(80);
        ExecutorService pool=Executors.newFixedThreadPool(10);
        while(true){
            Socket client=server.accept();
            System.out.println("用户"+client.getInetAddress().getHostAddress()+"连接成功！");
            pool.execute(new Task(client));
        }
    }
}
