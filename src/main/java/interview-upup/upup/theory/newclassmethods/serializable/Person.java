package upup.theory.newclassmethods.serializable;

import java.io.Serializable;

/**
 * @author Yuan Jiajun
 * @date 2020/9/8 20:01
 * @description @link
 */

public class Person implements Serializable {
    int age;
    int height;
    String name;
    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}

