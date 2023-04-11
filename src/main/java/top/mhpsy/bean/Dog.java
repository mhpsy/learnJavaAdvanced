package top.mhpsy.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.mhpsy.An.MyComponent;
import top.mhpsy.An.MyValue;

import java.lang.annotation.Target;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MyComponent
public class Dog {
    private static String TAG = "Dog";
    @MyValue("dog")
    private String name;
    @MyValue("3")
    private int age;

    public void say() {
        System.out.println("I am a dog");
    }
}
