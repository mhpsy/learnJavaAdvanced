package top.mhpsy.bean;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class refMain {
    private static Properties properties = null;

    static {
        properties = new Properties();
        try {
            properties.load(refMain.class.getClassLoader().getResourceAsStream("bean.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Object beanPath = properties.get("beanPath");
        Class<?> cls = Class.forName(beanPath.toString());
        Constructor<?> constructor = cls.getConstructor();
        Object c1 = constructor.newInstance();
        System.out.println(c1);


        Constructor<?> constructor1 = cls.getConstructor(String.class, int.class);
        Object c2 = constructor1.newInstance("Tom", 2);

        Method say = cls.getMethod("say");
        say.invoke(c2);

        Field tag = cls.getDeclaredField("TAG");
        tag.setAccessible(true);
        System.out.println(tag.get(null));//静态属性 所以传入null
        tag.set(null, "animal");
        System.out.println(tag.get(null));//静态属性 所以传入null
        System.out.println(tag.get(c1));
        System.out.println(tag.get(c2));


    }
}
