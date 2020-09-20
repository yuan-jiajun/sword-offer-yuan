package upup.jdktheory.shallowdeepcopy;

import org.junit.Test;

import java.io.*;

/**
 * @author yuanjiajun
 * @date 2020/9/9 23:53
 * @description 选择：
 * 如果对象的属性全是基本类型的，那么可以使用浅拷贝。
 * 如果对象有引用属性，那就要基于具体的需求来选择浅拷贝还是深拷贝。
 * 意思是如果对象引用任何时候都不会被改变，那么没必要使用深拷贝，只需要使用浅拷贝就行了。如果对象引用经常改变，那么就要使用深拷贝。没有一成不变的规则，一切都取决于具体需求。
 */
public class ObjectCopyTests {
    @Test
    public void testShallowCopy() {
        // 原始对象
        ShallowCopyStudent shallowOriginal = new ShallowCopyStudent("yuan", "stage1");
        System.out.println("原始对象: " + shallowOriginal.getName() + " - " + shallowOriginal.getSubj().getName());

        // 拷贝对象
        ShallowCopyStudent shallowCopy = (ShallowCopyStudent) shallowOriginal.clone();
        System.out.println("拷贝对象: " + shallowCopy.getName() + " - " + shallowCopy.getSubj().getName());

        // 原始对象和拷贝对象是否一样：
        System.out.println("原始对象toString: " + (shallowOriginal.toString()));
        System.out.println("拷贝对象toString: " + (shallowCopy.toString()));
        System.out.println("原始对象和拷贝对象是否一样: " + (shallowOriginal == shallowCopy));
        // 原始对象和拷贝对象的name属性是否一样
        System.out.println("原始对象和拷贝对象的name属性是否一样: " + (shallowOriginal.getName() == shallowCopy.getName()));
        // 原始对象和拷贝对象的subj属性是否一样
        System.out.println("原始对象和拷贝对象的subj属性是否一样: " + (shallowOriginal.getSubj() == shallowCopy.getSubj()));

        shallowOriginal.setName("jia");
        shallowOriginal.getSubj().setName("stage2");
        System.out.println("更新后的原始对象: " + shallowOriginal.getName() + " - " + shallowOriginal.getSubj().getName());
        System.out.println("更新原始对象后的克隆对象: " + shallowCopy.getName() + " - " + shallowCopy.getSubj().getName());
    }

    @Test
    public void testDeepCopy() {
        // 原始对象
        DeepCopyStudent deepOriginal = new DeepCopyStudent("yuan", "stage1");
        System.out.println("原始对象: " + deepOriginal.getName() + " - " + deepOriginal.getSubj().getName());

        // 拷贝对象
        DeepCopyStudent deepCopy = (DeepCopyStudent) deepOriginal.clone();
        System.out.println("拷贝对象: " + deepCopy.getName() + " - " + deepCopy.getSubj().getName());

        // 原始对象和拷贝对象是否一样：
        System.out.println("原始对象toString: " + (deepOriginal.toString()));
        System.out.println("拷贝对象toString: " + (deepCopy.toString()));
        System.out.println("原始对象和拷贝对象是否一样: " + (deepOriginal == deepCopy));
        // 原始对象和拷贝对象的name属性是否一样
        System.out.println("原始对象和拷贝对象的name属性是否一样: " + (deepOriginal.getName() == deepCopy.getName()));
        // 原始对象和拷贝对象的subj属性是否一样
        System.out.println("原始对象和拷贝对象的subj属性是否一样: " + (deepOriginal.getSubj() == deepCopy.getSubj()));

        deepOriginal.setName("jia");
        deepOriginal.getSubj().setName("stage2");
        System.out.println("更新后的原始对象: " + deepOriginal.getName() + " - " + deepOriginal.getSubj().getName());
        System.out.println("更新原始对象后的克隆对象: " + deepCopy.getName() + " - " + deepCopy.getSubj().getName());
    }

    @Test//序列化实现深拷贝
    public void test3() {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            // 创建原始的可序列化对象
            ColoredCircle c1 = new ColoredCircle(100, 100);
            System.out.println("原始的对象:" + c1);
            ColoredCircle c2 = null;

            // 通过序列化实现深拷贝
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);

            // 序列化以及传递这个对象
            oos.writeObject(c1);
            oos.flush();

            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);

            // 返回新的对象
            c2 = (ColoredCircle) ois.readObject();
            // 校验内容是否相同
            System.out.println("复制后的对象:" + c2);

            // 改变原始对象的内容
            c1.setX(200);
            c1.setY(200);
            // 查看每一个现在的内容
            System.out.println("改变原始对象后查看原始的对象:" + c1);
            System.out.println("改变原始对象后查看复制的对象:" + c2);

        } catch (IOException e) {
            System.out.println("Exception in main:" + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}