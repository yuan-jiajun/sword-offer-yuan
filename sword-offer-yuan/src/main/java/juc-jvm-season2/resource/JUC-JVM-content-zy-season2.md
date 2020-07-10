# JUC、JMM核心知识点笔记

尚硅谷周阳老师课程——[互联网大厂高频重点面试题第2季](https://www.bilibili.com/video/av48961087/)笔记。


[JUC笔记](https://github.com/MaJesTySA/JVM-JUC-Core/blob/master/docs/JUC.md) / [JVM笔记](https://github.com/MaJesTySA/JVM-JUC-Core/blob/master/docs/JVM.md) / [脑图下载](https://github.com/MaJesTySA/JVM-JUC-Core/raw/master/docs/jvm%20juc.xmind)

![脑图](https://raw.githubusercontent.com/MaJesTySA/JVM-JUC-Core/master/imgs/mindmap.png)

# JUC知识点

- JMM（Java内存模型） 
- volatile关键字 Java虚拟机提供的轻量级的同步机制
  - 可见性(内存可见性)
  - 不保证原子性（synchronized保证） 
  - 有序性（禁止指令重排）
  
  - 哪些地方用到过volatile？
    - 单例模式的安全问题
    
    
- CAS
  - CAS底层原理
  - CAS缺点
- ABA问题
  - AtomicReference
  - AtomicStampedReference和ABA问题的解决
- 集合类不安全问题
  - List
    - CopyOnWriteArrayList
  - Set
    - HashSet和HashMap
  - Map
- Java锁
  - 公平锁/非公平锁
  - 可重入锁/递归锁
    - 锁的配对
  - 自旋锁
  - 读写锁/独占/共享锁
  - Synchronized和Lock的区别
- Demos.juc.CountDownLatchDemo/CyclicBarrier/Semaphore
  - Demos.juc.CountDownLatchDemo
    - 枚举类的使用
  - CyclicBarrier
  - Semaphore
- 阻塞队列
  - SynchronousQueue
- Callable接口
- 阻塞队列的应用——生产者消费者
  - 传统模式
  - 阻塞队列模式
- 阻塞队列的应用——线程池
  - 线程池基本概念
  - 线程池三种常用创建方式
  - 线程池创建的七个参数
  - 线程池底层原理
  - 线程池的拒绝策略
  - 实际生产使用哪一个线程池？
    - 自定义线程池参数选择
- 死锁编码和定位

# JVM知识点

- Java8  JVM内存结构
- GC Roots
  - 如果判断一个对象可以被回收？
    - 引用计数算法
    - 可达性分析算法
  - 哪些对象可以作为GC Roots？
- JVM参数
  - JVM 三种类型参数
    - 标配参数
    - X参数
    - XX参数
  - JVM XX参数
    - 布尔类型
    - KV键值类型
  - JVM Xms/Xmx参数
  - JVM 查看参数
    - 查看某个参数
    - 查看所有参数
    - 查看修改后的参数
    - 查看常见参数
  - JVM 常用参数
    - -Xmx/-Xms
    - -Xss
    - -Xmn
    - -XX:MetaspaceSize
    - -XX:+PrintGCDetails
    - -XX:SurvivorRatio
    - -XX:NewRatio
    - -XX:MaxTenuringThreshold
- 四大引用
  - 强引用
  - 软引用
  - 弱引用
    - WeakHashMap
  - 虚引用
  - 引用队列
- OutOfMemoryError
  - StackOverflowError
  - OOM—Java head space
  - OOM—GC overhead limit exceeded
  - OOM—GC Direct buffer memory
  - OOM—unable to create new native thread
  - OOM—Metaspace
- JVM垃圾收集器
  - 四大垃圾收集算法
    - 标记整理
    - 标记清除
    - 复制算法
    - 分代收集算法
  - 四种垃圾收集器
    - 串行收集器Serial
    - 并行收集器Parrallel
    - 并发收集器CMS
    - G1收集器
  - 默认垃圾收集器
    - 默认收集器有哪些？
    - 查看默认垃圾修改器
  - 七大垃圾收集器
    - 体系结构
    - Serial收集器
    - ParNew收集器
    - Parallel Scavenge收集器
    - SerialOld收集器
    - ParallelOld收集器
    - CMS收集器
      - 过程
      - 优缺点
    - G1收集器
      - 特点
      - 过程
- 附—Linux相关指令
  - top
  - vmstat
  - pidstat
  - free
  - df
  - iostat
  - ifstat
- CPU占用过高原因定位
- JVM性能调优和监控工具
  - jps
  - jstack
  - jinfo/jstat
  - jmap