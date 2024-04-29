package implementation.interfaces;

/**
 * @author Yuan Jiajun
 * @date 2020/9/7 21:19
 * @description @link
 * 1、个Interface的方所有法访问权限自动被声明为public。确切的说只能为public，当然你可以显示的声明为protected、private，但是编译会出错！
 * 2、接口中可以定义“成员变量”，或者说是不可变的常量，因为接口中的“成员变量”会自动变为为public static final。可以通过类命名直接访问：ImplementClass.name。
 * 3、接口中不存在实现的方法。
 * 4、实现接口的非抽象类必须要实现该接口的所有方法。抽象类可以不用实现。
 * 5、不能使用new操作符实例化一个接口，但可以声明一个接口变量，该变量必须引用（refer to)一个实现该接口的类的对象。可以使用 instanceof 检查一个对象是否实现了某个特定的接口。例如：if(anObject instanceof Comparable){}。
 * 6、在实现多接口的时候一定要避免方法名的重复。
 */
public interface InterfaceDemo {
    public static final int a = 0;

    public static int method1() {
        System.out.println("");
        return 0;
    }

    public int method2();//不能用final修饰

//    public int method3(){//接口内非静态方法不能用包含方法体
//    };


}
