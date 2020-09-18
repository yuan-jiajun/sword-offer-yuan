package upup.grammar.newclassmethods.clone;

/**
 * @author Yuan Jiajun
 * @date 2020/9/8 19:57
 * @description @link
 * 注意：
 * 1.clone是Object中的方法，
 * Cloneable是一个标识接口，它表明这个类的对象是可以拷贝的。如果没有实现Cloneable接口却调用了clone()函数将抛出异常
 * 2.Object.clone()未做同步处理，线程不安全
 * 3.clone()有深拷贝和浅拷贝两种方式
 */
public class User implements Cloneable {
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

    public User(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        try {
            User source = new User("qinsuqi", 18);
            User copyUser = (User) source.clone();
            System.out.println("new clone:" + source.getName());
            System.out.println("copyClone:" + copyUser.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}