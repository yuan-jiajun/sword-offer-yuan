package chapter10;

/**
 * 测试对象实例化的过程
 * ① 加载类元信息
 * ② 为对象分配内存
 * ③ 处理并发问题
 * ④ 属性的默认初始化（零值初始化）
 * ⑤ 设置对象头的信息
 * ⑥ 属性的显式初始化、代码块中初始化、构造器中初始化
 * <p>
 * <p>
 * 给对象的属性赋值的操作：
 * ① 属性的默认初始化 - ② 显式初始化 / ③ 代码块中初始化 - ④ 构造器中初始化
 *
 * @create 2020  18:42
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer cust = new Customer();
        System.out.println(cust.id);
        System.out.println(cust.age);
        System.out.println(cust.gender);
        System.out.println(cust.name);
    }
}
