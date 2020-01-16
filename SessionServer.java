package V2;

import V2.business.User;

import java.io.*;
import java.util.UUID;

/**
 * @ClassName SessionServer
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 15:30]
 * @Version 1.0
 **/

public class SessionServer {
    private static String dir="会话";

    public static String put(User user)throws IOException {
        String sessionid=UUID.randomUUID().toString();
        String filename=dir+"\\"+sessionid;
        OutputStream os=new FileOutputStream(filename);
        ObjectOutputStream oos=new ObjectOutputStream(os);
        oos.writeObject(user);
        os.close();
        return sessionid;
    }
    public static User get(String sessionid)throws IOException{
        String filename=dir+"\\"+sessionid;
        InputStream is=new FileInputStream(filename);
        ObjectInputStream ois=new ObjectInputStream(is);
        User user=null;
        try {
            user=(User) ois.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        is.close();
        return user;
    }
}
