package creation_patters.prototype;

/**
 * @author Yuan Jiajun
 * @date 2020/9/23 15:55
 * @description @link
 */

////具体原型类
//class Realizetype implements Cloneable {
//    Realizetype() {
//        System.out.println("具体原型创建成功！");
//    }
//
//    public Object clone() throws CloneNotSupportedException {
//        System.out.println("具体原型复制成功！");
//        return super.clone();
//    }
//}

//原型模式的测试类
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype obj1 = new Realizetype();
        Realizetype obj2 = (Realizetype) obj1.clone();
        System.out.println("obj1==obj2?  " + (obj1 == obj2));
    }
}

class Realizetype implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
//        System.out.println("具体原型复制成功！");
        return super.clone();
    }
}