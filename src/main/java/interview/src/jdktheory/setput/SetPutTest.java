package jdktheory.setput;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yuan Jiajun
 * @date 2020/9/21 16:04
 * @description @link
 */
public class SetPutTest {

    /**
     * 验证问题：
     * 往set里面put一个学生对象，然后将这个学生对象的学号改了，再put进去，可以放进set么？并讲出为什么
     * 答：不可以放入，因为修改学号并不会修改这个学生对象的hashcode，set不能存放相同（使用equals判断成立）的元素
     * 修改 hashcode的生成方法即可放入
     */

    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        Student s1 = new Student("1", "yuanjiajun");
//        Student s2 = new Student("1", "yuanjiajun");

//        往集合中放入学生对象s1
        set.add(s1);
        System.out.println(s1.hashCode());
//        修改s1的学号
        s1.setSid("2");
        System.out.println(s1.hashCode());
//        set.add(s1);

//        set.add(s2);
//        尝试放入修改后的s1
//        if (set.add(s1)) {
//            System.out.println("可以放入");
//        } else {
//            System.out.println("不可以放入");
//        }

        set.remove(s1);

        set.remove(new Student("1", "yuanjiajun"));
        set.remove(new Student("2", "yuanjiajun"));
//        set.remove(new Student("2", "yuanjiajun"));
//        set.removeAll(set);

        for (Student s : set) {
            set.remove(s);
        }

        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Student s : set) {
            System.out.println(s.hashCode() + " 学号:" + s.getSid() + " 姓名:" + s.getSname());
        }
    }

}






