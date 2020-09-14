package upup.theory.newclassmethods.newkeyword;

/**
 * @author Yuan Jiajun
 * @date 2020/9/8 19:54
 * @description @link
 * 首先在方法区的常量池中查看是否有new 后面参数（也就是类名）的符号引用，
 * 并检查是否有类的加载信息也就是是否被加载解析和初始化过。如果已经加载过了就不在加载，否则执行类的加载全过程
 * <p>
 * 加载完类后，大致做了如下三件事：
 * a、给实例分配内存
 * b、调用构造函数，初始化成员字段
 * c、user对象指向分配的内存空间
 * <p>
 * 注意：new操作不是原子操作，b和c的顺序可能会调换
 */
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        User user = new User();
    }
}