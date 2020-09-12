## Java Minor GC、Major GC和Full GC之间的区别

- Minor GC

  - Minor GC指新生代GC，即发生在新生代（包括Eden区和Survivor区）的垃圾回收操作，当新生代无法为新生对象分配内存空间的时候，会触发Minor GC。因为新生代中大多数对象的生命周期都很短，所以发生Minor GC的频率很高，虽然它会触发stop-the-world，但是它的回收速度很快。

- Major GC

  - Major GC清理Tenured区，用于回收老年代，出现Major GC通常会出现至少一次Minor GC。

- Full GC

  - Full GC是针对整个新生代、老生代、元空间（metaspace，java8以上版本取代perm gen）的全局范围的GC。Full GC不等于Major GC，也不等于Minor GC+Major GC，发生Full GC需要看使用了什么垃圾收集器组合，才能解释是什么样的垃圾回收。

    

## MinorGC触发条件

虚拟机在进行minorGC之前会判断**老年代最大的可用连续空间是否大于新生代的所有对象总空间**

- 如果大于的话，直接执行minorGC

- 如果小于，判断是否开启HandlerPromotionFailure
  - 没有开启直接FullGC
  - 开启，JVM会判断**老年代的最大连续内存空间是否大于历次晋升（晋级老年代对象的平均大小）平均值的大小**
    - 如果大于，执行MinorGC
    - 如果小于，执行FullGC

对于HandlerPromotionFailure，我们可以这样理解，在发生Minor GC之前，虚拟机会先检查老年代的最大的连续内存空间是否大于新生代的所有对象的空间，如果这个条件成立，Minor GC是安全的。如果不成立虚拟机会查看HanlerPromotionFailure 设置值是否允许担当失败，如果允许，那么会继续检查老年代最大可用的连续内存空间是否大于历次晋级到老年代对象的平均大小，如果大于就尝试一次Minor GC， 如果小于，或者HanlerPromotionFailure 不愿承担风险就要进行一次Full GC。



## FullGC触发条件

- 显示调用System.gc()

  这里调用了 System.gc() 并不一定会立马就触发FullGC

- 老年代空间不足

   如果创建一个大对象，Eden区域当中放不下这个大对象，会直接保存在老年代当中，如果老年代空间也不足，就会触发Full GC。为了避免这种情况，最好就是不要创建太大的对象。

- 方法区空间不足

   如果有方法区空间的话，系统当中需要加载的类，调用的方法很多，同时方法区当中没有足够的空间，就出触发一次Full GC

- MinorGC出现promotion failure

  promotion failure发生在MinorGCGC, 如果Survivor区当中存活对象的年龄达到了设定值，会就将Survivor区当中的对象拷贝到老年代，如果老年代的空间不足，就会发生promotion failure， 接下去就会发生Full GC.

- 统计MinorGC发生时晋升到老年代的平均总大小大于老年代的空闲空间

   在发生MinorGC是会判断，是否安全，这里的安全指的是，当前老年代空间可以容纳MinorGC晋升的对象的平均大小，如果不安全，就不会执行MinorGC,转而执行FullGC。

## 虚拟机栈与本地方法栈

### 虚拟机栈
**栈区:**
**栈中分配的是基本类型和自定义对象的引用。**
每个线程包含一个栈区，栈中只保存基础数据类型和自定义对象的引用(不是对象)，对象都存放在堆区中
每个栈中的数据(原始类型和对象引用)都是私有的，其他栈不能访问。
栈分为3个部分：基本类型变量区、执行环境上下文、操作指令区(存放操作指令)。
栈是存放线程调用方法时存储局部变量表，操作，方法出口等与方法执行相关的信息，栈大小由Xss来调节，方法调用层次太多会撑爆这个区域。
栈溢出一般只会出现无限循环的递归中，另外，线程太多也会占满栈区域

**栈帧：**
一个完整的栈帧包含：局部变量表（基本数据类型变量），操作数栈，动态连接信息，方法完成和异常完成信息。
局部变量表概念和特征：
由若干个Slot组成，长度由编译期决定。
单个Slot可以存储一个类型为boolean ,byte,char, short, float, reference和returnAddress的数据，两个Slot可以存储一个类型为long或double的数据。
局部变量表用于方法间参数传递，以及方法执行过程中存储基础数据类型的值和对象的引用。

### 本地方法栈：
本地方法栈的特征:
线程私有
后进先出栈
作用是支撑Native方法的调用，执行和退出
可能出现OutOfMemoryError异常和StackOverflowError异常

-----
Java虚拟机栈和本地方法栈可能发生如下
如果线程请求分配的栈容量超过Java虚拟机栈允许的最大容量时，Java虚拟机将会抛出一个StackOverflowError异常。
如果Java虚拟机可以动态扩展，并且扩展的动作已经尝试过，但是目前无法申请到足够的内存去完成扩展，或者在建立新的线程时没有足够的内存去创建对应的虚拟机栈，那Java虚拟机将会抛出一个OutOfMemoryError异常。



## 方法区 & 堆空间

在Hotspot中，方法区只是在逻辑上独立，物理上还是包含在堆区中。但是其它的虚拟机可能就不是这种情况

