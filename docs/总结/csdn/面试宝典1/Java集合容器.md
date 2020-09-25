### Java集合容器

- [集合容器概述](https://thinkwon.blog.csdn.net/article/details/104588551#_36)

- - [什么是集合](https://thinkwon.blog.csdn.net/article/details/104588551#_38)
  - [集合的特点](https://thinkwon.blog.csdn.net/article/details/104588551#_57)
  - [集合和数组的区别](https://thinkwon.blog.csdn.net/article/details/104588551#_67)
  - [使用集合框架的好处](https://thinkwon.blog.csdn.net/article/details/104588551#_83)
  - [常用的集合类有哪些？](https://thinkwon.blog.csdn.net/article/details/104588551#_93)
  - [List，Set，Map三者的区别？List、Set、Map 是否继承自 Collection 接口？List、Map、Set 三个接口存取元素时，各有什么特点？](https://thinkwon.blog.csdn.net/article/details/104588551#ListSetMapListSetMap__Collection_ListMapSet__104)
  - [集合框架底层数据结构](https://thinkwon.blog.csdn.net/article/details/104588551#_121)
  - [哪些集合类是线程安全的？](https://thinkwon.blog.csdn.net/article/details/104588551#_148)
  - [Java集合的快速失败机制 “fail-fast”？](https://thinkwon.blog.csdn.net/article/details/104588551#Java_failfast_157)
  - [怎么确保一个集合不能被修改？](https://thinkwon.blog.csdn.net/article/details/104588551#_173)

- [Collection接口](https://thinkwon.blog.csdn.net/article/details/104588551#Collection_191)

- - [List接口](https://thinkwon.blog.csdn.net/article/details/104588551#List_193)

  - - [迭代器 Iterator 是什么？](https://thinkwon.blog.csdn.net/article/details/104588551#_Iterator__195)
    - [Iterator 怎么使用？有什么特点？](https://thinkwon.blog.csdn.net/article/details/104588551#Iterator__201)
    - [如何边遍历边移除 Collection 中的元素？](https://thinkwon.blog.csdn.net/article/details/104588551#_Collection__218)
    - [Iterator 和 ListIterator 有什么区别？](https://thinkwon.blog.csdn.net/article/details/104588551#Iterator__ListIterator__243)
    - [遍历一个 List 有哪些不同的方式？每种方法的实现原理是什么？Java 中 List 遍历的最佳实践是什么？](https://thinkwon.blog.csdn.net/article/details/104588551#_List_Java__List__251)
    - [说一下 ArrayList 的优缺点](https://thinkwon.blog.csdn.net/article/details/104588551#_ArrayList__271)
    - [如何实现数组和 List 之间的转换？](https://thinkwon.blog.csdn.net/article/details/104588551#_List__287)
    - [ArrayList 和 LinkedList 的区别是什么？](https://thinkwon.blog.csdn.net/article/details/104588551#ArrayList__LinkedList__308)
    - [ArrayList 和 Vector 的区别是什么？](https://thinkwon.blog.csdn.net/article/details/104588551#ArrayList__Vector__324)
    - [插入数据时，ArrayList、LinkedList、Vector谁速度较快？阐述 ArrayList、Vector、LinkedList 的存储性能和特性？](https://thinkwon.blog.csdn.net/article/details/104588551#ArrayListLinkedListVector_ArrayListVectorLinkedList__338)
    - [多线程场景下如何使用 ArrayList？](https://thinkwon.blog.csdn.net/article/details/104588551#_ArrayList_349)
    - [为什么 ArrayList 的 elementData 加上 transient 修饰？](https://thinkwon.blog.csdn.net/article/details/104588551#_ArrayList__elementData__transient__366)
    - [List 和 Set 的区别](https://thinkwon.blog.csdn.net/article/details/104588551#List__Set__404)

  - [Set接口](https://thinkwon.blog.csdn.net/article/details/104588551#Set_423)

  - - [说一下 HashSet 的实现原理？](https://thinkwon.blog.csdn.net/article/details/104588551#_HashSet__425)
    - [HashSet如何检查重复？HashSet是如何保证数据不可重复的？](https://thinkwon.blog.csdn.net/article/details/104588551#HashSetHashSet_431)
    - [HashSet与HashMap的区别](https://thinkwon.blog.csdn.net/article/details/104588551#HashSetHashMap_471)

  - [Queue](https://thinkwon.blog.csdn.net/article/details/104588551#Queue_485)

  - - [BlockingQueue是什么？](https://thinkwon.blog.csdn.net/article/details/104588551#BlockingQueue_487)
    - [在 Queue 中 poll()和 remove()有什么区别？](https://thinkwon.blog.csdn.net/article/details/104588551#_Queue__poll_remove_493)

- [Map接口](https://thinkwon.blog.csdn.net/article/details/104588551#Map_512)

- - [说一下 HashMap 的实现原理？](https://thinkwon.blog.csdn.net/article/details/104588551#_HashMap__514)

  - [HashMap在JDK1.7和JDK1.8中有哪些不同？HashMap的底层实现](https://thinkwon.blog.csdn.net/article/details/104588551#HashMapJDK17JDK18HashMap_531)

  - - [JDK1.8之前](https://thinkwon.blog.csdn.net/article/details/104588551#JDK18_535)
    - [JDK1.8之后](https://thinkwon.blog.csdn.net/article/details/104588551#JDK18_543)
    - [JDK1.7 VS JDK1.8 比较](https://thinkwon.blog.csdn.net/article/details/104588551#JDK17_VS_JDK18__551)

  - [HashMap的put方法的具体流程？](https://thinkwon.blog.csdn.net/article/details/104588551#HashMapput_570)

  - [HashMap的扩容操作是怎么实现的？](https://thinkwon.blog.csdn.net/article/details/104588551#HashMap_682)

  - [HashMap是怎么解决哈希冲突的？](https://thinkwon.blog.csdn.net/article/details/104588551#HashMap_796)

  - - [什么是哈希？](https://thinkwon.blog.csdn.net/article/details/104588551#_800)
    - [什么是哈希冲突？](https://thinkwon.blog.csdn.net/article/details/104588551#_806)
    - [HashMap的数据结构](https://thinkwon.blog.csdn.net/article/details/104588551#HashMap_810)
    - [hash()函数](https://thinkwon.blog.csdn.net/article/details/104588551#hash_818)
    - [JDK1.8新增红黑树](https://thinkwon.blog.csdn.net/article/details/104588551#JDK18_831)
    - [总结](https://thinkwon.blog.csdn.net/article/details/104588551#_837)

  - [能否使用任何类作为 Map 的 key？](https://thinkwon.blog.csdn.net/article/details/104588551#_Map__key_847)

  - [为什么HashMap中String、Integer这样的包装类适合作为K？](https://thinkwon.blog.csdn.net/article/details/104588551#HashMapStringIntegerK_862)

  - [如果使用Object作为HashMap的Key，应该怎么办呢？](https://thinkwon.blog.csdn.net/article/details/104588551#ObjectHashMapKey_871)

  - [HashMap为什么不直接使用hashCode()处理后的哈希值直接作为table的下标？](https://thinkwon.blog.csdn.net/article/details/104588551#HashMaphashCodetable_880)

  - [HashMap 的长度为什么是2的幂次方](https://thinkwon.blog.csdn.net/article/details/104588551#HashMap_2_891)

  - [HashMap 与 HashTable 有什么区别？](https://thinkwon.blog.csdn.net/article/details/104588551#HashMap__HashTable__905)

  - [如何决定使用 HashMap 还是 TreeMap？](https://thinkwon.blog.csdn.net/article/details/104588551#_HashMap__TreeMap_916)

  - [HashMap 和 ConcurrentHashMap 的区别](https://thinkwon.blog.csdn.net/article/details/104588551#HashMap__ConcurrentHashMap__922)

  - [ConcurrentHashMap 和 Hashtable 的区别？](https://thinkwon.blog.csdn.net/article/details/104588551#ConcurrentHashMap__Hashtable__929)

  - [ConcurrentHashMap 底层具体实现知道吗？实现原理是什么？](https://thinkwon.blog.csdn.net/article/details/104588551#ConcurrentHashMap__956)

- [辅助工具类](https://thinkwon.blog.csdn.net/article/details/104588551#_1025)

- - [Array 和 ArrayList 有何区别？](https://thinkwon.blog.csdn.net/article/details/104588551#Array__ArrayList__1027)
  - [如何实现 Array 和 List 之间的转换？](https://thinkwon.blog.csdn.net/article/details/104588551#_Array__List__1037)
  - [comparable 和 comparator的区别？](https://thinkwon.blog.csdn.net/article/details/104588551#comparable__comparator_1044)
  - [Collection 和 Collections 有什么区别？](https://thinkwon.blog.csdn.net/article/details/104588551#Collection__Collections__1053)
  - [TreeMap 和 TreeSet 在排序时如何比较元素？Collections 工具类中的 sort()方法如何比较元素？](https://thinkwon.blog.csdn.net/article/details/104588551#TreeMap__TreeSet_Collections__sort_1060)