package V2.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 15:25]
 * @Version 1.0
 **/

public class User implements Serializable {
    public String id;
    public String username;
    public int balance;
    static List<User> users= new ArrayList<>();

    public User(String id, String username, int balance) {

        this.id = id;
        this.username = username;
        this.balance = balance;
    }
    static {
        users.add(new User("1","马云",300));
        users.add(new User("2","马化腾",200));
        users.add(new User("3","许家印",100));
    }
    public static User findUser(String username){
        for(User user:users){
            if(user.username.equals(username)){
                return user;
            }
        }
        return null;
    }
}
