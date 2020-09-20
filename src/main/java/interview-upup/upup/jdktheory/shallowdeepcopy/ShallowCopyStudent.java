package upup.jdktheory.shallowdeepcopy;

/**
 * @author Yuan Jiajun
 * @date 2020/9/9 22:50
 * @description @link
 */
public class ShallowCopyStudent implements Cloneable {

    // 对象引用
    private String name;
    private Subject subj;

    public ShallowCopyStudent(String s, String sub) {
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
     * 重写clone()方法，浅拷贝
     */
    public Object clone() {
        //浅拷贝
        try {
            // 直接调用父类的clone()方法
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }


}
