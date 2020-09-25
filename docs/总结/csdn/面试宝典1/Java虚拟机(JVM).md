### Java虚拟机(JVM)

- [Java内存区域](https://thinkwon.blog.csdn.net/article/details/104390752#Java_35)

- - [说一下 JVM 的主要组成部分及其作用？](https://thinkwon.blog.csdn.net/article/details/104390752#_JVM__37)
  - [说一下 JVM 运行时数据区](https://thinkwon.blog.csdn.net/article/details/104390752#_JVM__68)
  - [深拷贝和浅拷贝](https://thinkwon.blog.csdn.net/article/details/104390752#_88)
  - [说一下堆栈的区别？](https://thinkwon.blog.csdn.net/article/details/104390752#_104)
  - [队列和栈是什么？有什么区别？](https://thinkwon.blog.csdn.net/article/details/104390752#_143)

- [HotSpot虚拟机对象探秘](https://thinkwon.blog.csdn.net/article/details/104390752#HotSpot_153)

- - [对象的创建](https://thinkwon.blog.csdn.net/article/details/104390752#_155)

  - [为对象分配内存](https://thinkwon.blog.csdn.net/article/details/104390752#_175)

  - [处理并发安全问题](https://thinkwon.blog.csdn.net/article/details/104390752#_188)

  - [对象的访问定位](https://thinkwon.blog.csdn.net/article/details/104390752#_199)

  - - [句柄访问](https://thinkwon.blog.csdn.net/article/details/104390752#_207)
    - [直接指针](https://thinkwon.blog.csdn.net/article/details/104390752#_217)

- [内存溢出异常](https://thinkwon.blog.csdn.net/article/details/104390752#_227)

- - [Java会存在内存泄漏吗？请简单描述](https://thinkwon.blog.csdn.net/article/details/104390752#Java_229)

- [垃圾收集器](https://thinkwon.blog.csdn.net/article/details/104390752#_237)

- - [简述Java垃圾回收机制](https://thinkwon.blog.csdn.net/article/details/104390752#Java_239)

  - [GC是什么？为什么要GC](https://thinkwon.blog.csdn.net/article/details/104390752#GCGC_245)

  - [垃圾回收的优点和原理。并考虑2种回收机制](https://thinkwon.blog.csdn.net/article/details/104390752#2_255)

  - [垃圾回收器的基本原理是什么？垃圾回收器可以马上回收内存吗？有什么办法主动通知虚拟机进行垃圾回收？](https://thinkwon.blog.csdn.net/article/details/104390752#_270)

  - [Java 中都有哪些引用类型？](https://thinkwon.blog.csdn.net/article/details/104390752#Java__280)

  - [怎么判断对象是否可以被回收？](https://thinkwon.blog.csdn.net/article/details/104390752#_289)

  - [在Java中，对象什么时候可以被垃圾回收](https://thinkwon.blog.csdn.net/article/details/104390752#Java_300)

  - [JVM中的永久代中会发生垃圾回收吗](https://thinkwon.blog.csdn.net/article/details/104390752#JVM_307)

  - [说一下 JVM 有哪些垃圾回收算法？](https://thinkwon.blog.csdn.net/article/details/104390752#_JVM__314)

  - - [标记-清除算法](https://thinkwon.blog.csdn.net/article/details/104390752#_323)
    - [复制算法](https://thinkwon.blog.csdn.net/article/details/104390752#_344)
    - [标记-整理算法](https://thinkwon.blog.csdn.net/article/details/104390752#_358)
    - [分代收集算法](https://thinkwon.blog.csdn.net/article/details/104390752#_372)

  - [说一下 JVM 有哪些垃圾回收器？](https://thinkwon.blog.csdn.net/article/details/104390752#_JVM__380)

  - [详细介绍一下 CMS 垃圾回收器？](https://thinkwon.blog.csdn.net/article/details/104390752#_CMS__396)

  - [新生代垃圾回收器和老年代垃圾回收器都有哪些？有什么区别？](https://thinkwon.blog.csdn.net/article/details/104390752#_404)

  - [简述分代垃圾回收器是怎么工作的？](https://thinkwon.blog.csdn.net/article/details/104390752#_414)

- [内存分配策略](https://thinkwon.blog.csdn.net/article/details/104390752#_432)

- - [简述java内存分配与回收策率以及Minor GC和Major GC](https://thinkwon.blog.csdn.net/article/details/104390752#javaMinor_GCMajor_GC_434)

  - - [对象优先在 Eden 区分配](https://thinkwon.blog.csdn.net/article/details/104390752#_Eden__440)
    - [大对象直接进入老年代](https://thinkwon.blog.csdn.net/article/details/104390752#_451)
    - [长期存活对象将进入老年代](https://thinkwon.blog.csdn.net/article/details/104390752#_459)

- [虚拟机类加载机制](https://thinkwon.blog.csdn.net/article/details/104390752#_467)

- - [简述java类加载机制?](https://thinkwon.blog.csdn.net/article/details/104390752#java_469)
  - [描述一下JVM加载Class文件的原理机制](https://thinkwon.blog.csdn.net/article/details/104390752#JVMClass_475)
  - [什么是类加载器，类加载器有哪些?](https://thinkwon.blog.csdn.net/article/details/104390752#_489)
  - [说一下类装载的执行过程？](https://thinkwon.blog.csdn.net/article/details/104390752#_502)
  - [什么是双亲委派模型？](https://thinkwon.blog.csdn.net/article/details/104390752#_514)

- [JVM调优](https://thinkwon.blog.csdn.net/article/details/104390752#JVM_535)

- - [说一下 JVM 调优的工具？](https://thinkwon.blog.csdn.net/article/details/104390752#_JVM__537)
  - [常用的 JVM 调优的参数都有哪些？](https://thinkwon.blog.csdn.net/article/details/104390752#_JVM__546)