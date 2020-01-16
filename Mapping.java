package V2;

import V2.Servlet.HTTPServlet;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Mapping
 * @Description TODO
 * @Auther danni
 * @Date 2020/1/4 14:38]
 * @Version 1.0
 **/

public class Mapping {
    public Map<String,String> mapping=new HashMap<>();

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void putMapping(String key,String value) {
        mapping.put(key,value);
    }
    public HTTPServlet getclz(String key){
        if(mapping.containsKey(key)){
            String clzName=mapping.get(key);
            try {
                Class clz=Class.forName(clzName);
                HTTPServlet servlet=(HTTPServlet) clz.getConstructor().newInstance();
                return servlet;
            } catch (Exception e) {
                System.err.println("反射异常");
                return null;
            }
        }
        return null;
    }
}
