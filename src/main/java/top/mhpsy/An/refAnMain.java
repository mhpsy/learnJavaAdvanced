package top.mhpsy.An;

import top.mhpsy.bean.Dog;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class refAnMain {
    public static void main(String[] args) throws Exception {
        Class<Dog> dogClass = Dog.class;
        //getAnnotation的返回值是一个注解对象
        MyComponent annotation = dogClass.getAnnotation(MyComponent.class);
        if (annotation != null) {
            System.out.println("Dog is a component");
            Constructor<Dog> constructor = dogClass.getConstructor();
            Dog dog = constructor.newInstance();

            Field[] fields = dogClass.getDeclaredFields();
            for (Field field : fields) {
                //获取全部属性的注解 如果有MyValue注解就获取注解的值
                MyValue mv = field.getAnnotation(MyValue.class);
                if (mv != null) {
                    String value = mv.value();
                    System.out.println(value);
                    field.setAccessible(true);
                    /*
                    根据不同的属性类型进行赋值
                    Class<?> type = field.getType();
                    Constructor<?> typeConstructor = type.getConstructor(type);
                    Object realV = typeConstructor.newInstance(value);
                    field.set(dog, realV);
                    */

                    if (field.getType() == String.class) {
                        field.set(dog, value);
                    } else if (field.getType() == int.class) {
                        field.set(dog, Integer.parseInt(value));
                    }
                }
            }
            System.out.println(dog);

            //用反射添加一个属性
            Field field = dogClass.getDeclaredField("TAG");
            field.setAccessible(true);
            field.set(dog, "new TAG");
            System.out.println(field.get(dog));

        }
    }
}
