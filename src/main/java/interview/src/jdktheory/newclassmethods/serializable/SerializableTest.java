package jdktheory.newclassmethods.serializable;

import java.io.*;

/**
 * @author Yuan Jiajun
 * @date 2020/9/8 20:07
 * @description @link
 */

public class SerializableTest {

    /**
     * Java对象的序列化与反序列化
     */

    public static void main(String[] args) {
        Person zhangsan = new Person("zhangsan", 30, 170);
        Person lisi = new Person("lisi", 35, 175);
        Person wangwu = new Person("wangwu", 28, 178);

        String path = SerializableTest.class.getResource("").getPath() + "person.ser";

        try {
            //需要一个文件输出流和对象输出流；文件输出流用于将字节输出到文件，对象输出流用于将对象输出为字节
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(zhangsan);
            out.writeObject(lisi);
            out.writeObject(wangwu);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            Person one = (Person) in.readObject();
            Person two = (Person) in.readObject();
            Person three = (Person) in.readObject();
            System.out.println("name:" + one.name + " age:" + one.age + " height:" + one.height);
            System.out.println("name:" + two.name + " age:" + two.age + " height:" + two.height);
            System.out.println("name:" + three.name + " age:" + three.age + " height:" + three.height);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
