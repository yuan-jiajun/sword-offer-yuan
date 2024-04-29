package jdktheory.shallowdeepcopy;

/**
 * @author Yuan Jiajun
 * @date 2020/9/9 22:50
 * @description @link
 */
public class DeepCopyStudent implements Cloneable {

    // 对象引用
    private Subject subj;
    private String name;

    public DeepCopyStudent(String s, String sub) {
        name = s;
        subj = new Subject(sub);
    }

    public Subject getSubj() {
        return subj;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }


    /**
     * 重写clone()方法，深拷贝
     */
    public Object clone() {
        // 深拷贝，创建拷贝类的一个新对象，这样就和原始对象相互独立
        DeepCopyStudent s = new DeepCopyStudent(name, subj.getName());
        return s;
    }
}
