package upup.theory.newclassmethods.reflect.constructor;

import org.junit.Test;
import upup.theory.newclassmethods.reflect.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Yuan Jiajun
 * @date 2020/9/8 21:07
 * @description @see
 */

public class ConstructorInstance {

    @Test
    public void getConstructors() {
        Class<Person> p = Person.class;
        for (Constructor constructor : p.getConstructors()) {
            System.out.println(constructor);
        }
    }

    @Test
    public void getSpecialConstructor() throws NoSuchMethodException {
        Class<Person> p = Person.class;
        Constructor<Person> constructor1 = p.getConstructor();//获取默认的构造方法
        Constructor<Person> constructor2 = p.getConstructor(String.class, int.class);//获取指定的构造方法
        System.out.println(constructor1);
        System.out.println(constructor2);
    }

    @Test
    public void newInstanceBySpecialConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> p = Person.class;
        Constructor<Person> constructor = p.getConstructor(String.class, int.class);
        Person person = constructor.newInstance("酸辣汤", 18);
        System.out.println(person);
    }

    @Test
    public void newInstanceByDefaultConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> p = Person.class;
        Person person = p.getConstructor().newInstance();
        System.out.println(person);
    }


}



