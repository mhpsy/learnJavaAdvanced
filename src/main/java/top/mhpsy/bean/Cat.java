package top.mhpsy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    private static String TAG = "Dog";
    private String name;
    private int age;

    public void say() {
        System.out.println("I am a cat");
    }
}
