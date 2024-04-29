package jdktheory.newclassmethods.reflect.classnewinstance;

import interview222.jdktheory.newclassmethods.reflect.Person;

/**
 * @author Yuan Jiajun
 * @date 2020/9/8 21:06
 * @description @link
 */

public class ClassNewInstance {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Person person = Person.class.newInstance();
        person.setAge(18);
        person.setName("酸辣汤");
        System.out.println(person);
    }
}

