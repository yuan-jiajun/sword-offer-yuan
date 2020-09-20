package upup.jdktheory.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author Yuan Jiajun
 * @date 2020/9/10 22:38
 * @description @link
 */
public class IteratorDemos {
    @Test
    public void test() {
        ArrayList list = new ArrayList();
        // 增加：add() 将指定对象存储到容器中
        list.add("计算机网络");
        list.add("现代操作系统");
        list.add("java编程思想");
        list.add("java核心技术");
        list.add("java语言程序设计");
        System.out.println(list);

        /**while循环*/
        Iterator it = list.iterator();
        while (it.hasNext()) {

            // 调用remove之前没有调用next是不合法的
//             it.remove();
            // java.lang.IllegalStateException

            String next = (String) it.next();
            System.out.println(next);
        }

//         迭代器的指针已经指向了集合的末尾
//         String next = (String) it.next();
//         java.util.NoSuchElementException

    }

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        // 增加：add() 将指定对象存储到容器中
        list.add("计算机网络");
        list.add("现代操作系统");
        list.add("java编程思想");
        list.add("java核心技术");
        list.add("java语言程序设计");
        System.out.println(list);

        /**for循环*/

        for (Iterator it = list.iterator(); it.hasNext(); ) {
            //迭代器的next方法返回值类型是Object，所以要记得类型转换。
            String next = (String) it.next();
            System.out.println(next);

        }
    }

    /**
     * 第三种方式：使用迭代器清空集合
     */
    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");
        System.out.println(coll);

        Iterator it = coll.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        System.out.println(coll);
    }

    @Test
    public void test4() {
        //准备数据
        List<Student> list = new ArrayList<>();
        list.add(new Student("male"));
        list.add(new Student("female"));
        list.add(new Student("female"));
        list.add(new Student("male"));

        //遍历删除,除去男生
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if ("male".equals(student.getGender())) {
                iterator.remove();//使用迭代器的删除方法删除,正确可行的，也是开发中推荐使用的。
//                如果将上例中的iterator.remove(); 改为list.remove(student);
//                将会报ConcurrentModificationException异常。
//                这是因为：使用迭代器遍历，却使用集合的方法删除元素的结果。
            }
        }


        //高级for遍历删除元素，没有break/return
        //java.util.ConcurrentModificationException
/*        for (Student student : list) {
            if ("male".equals(student.getGender())) {
                list.remove(student);//使用集合的删除方法删除
            }
        }*/

    }

    /**
     * 总体来说，不建议使用高级for循环(增强for循环)遍历删除/增加操作。
     * 原因就是可能会报ConcurrentModificationException异常。
     * 说可能是比较准确的，可能会报，也可能不报。
     * <p>
     * 总结干货：
     * 1.使用高级for循环遍历删除/增加元素时，如果在某次循环的过程中进行了删除或者是增加元素的操作，
     * 使用break或者return语句结束了循环操作，不报异常。
     * 2.使用高级for循环遍历删除/增加元素时，除了1这种情况之外，
     * 必报ConcurrentModificationException异常。
     */
    @Test
    public void test5() {
        //准备数据
        List<Student> list = new ArrayList<>();
        list.add(new Student("male"));
        list.add(new Student("female"));
        list.add(new Student("female"));
        list.add(new Student("male"));

        //遍历删除增强for循环除去男生
        for (Student student : list) {
            if ("male".equals(student.getGender())) {
                list.remove(student);//使用集合的删除方法删除
                break;//或者return
            }
        }
        System.out.println("操作结果:" + list.toString());
    }

    @Test
    public void test6() {
//准备数据
        List<Student> list = new ArrayList<>();
        list.add(new Student("male"));
        list.add(new Student("male"));
        list.add(new Student("female"));
        list.add(new Student("female"));
        list.add(new Student("male"));

        //普通for循环遍历删除
        //这种使用普通for循环遍历删除的方法是可行的，但是如果每次删除一个元素之后忘记了将角标减一的话可能会出问题的。
        //问题：满足条件需要删除的元素没有完全删掉
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if ("male".equals(student.getGender())) {
                list.remove(i);//使用集合的删除方法删除
                i--;// 角标减一
            }
        }

        for (Student student : list) {
            System.out.println(student);
        }
    }


}

class Student {
    String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Student(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gender='" + gender + '\'' +
                '}';
    }
}
