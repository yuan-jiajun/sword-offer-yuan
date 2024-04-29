package jdktheory.newclassmethods.reflect.classforname;

import org.junit.Test;
import interview222.jdktheory.newclassmethods.reflect.Person;

/**
 * @author Yuan Jiajun
 * @date 2020/9/8 21:31
 * @description @link
 */
public class NewInstanceByClassForName {
    @Test
    public void newInstanceByClassForName() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String path = "upup.newclass.reflect.Person";
        Person person = (Person) Class.forName(path).newInstance();
        System.out.println(person);
    }
}