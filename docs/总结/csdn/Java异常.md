### Java异常

- [Java异常架构与异常关键字](https://thinkwon.blog.csdn.net/article/details/104390689#Java_36)

- - [Java异常简介](https://thinkwon.blog.csdn.net/article/details/104390689#Java_38)

  - [Java异常架构](https://thinkwon.blog.csdn.net/article/details/104390689#Java_45)

  - - [1. Throwable](https://thinkwon.blog.csdn.net/article/details/104390689#1_Throwable_49)

    - [2. Error（错误）](https://thinkwon.blog.csdn.net/article/details/104390689#2_Error_59)

    - [3. Exception（异常）](https://thinkwon.blog.csdn.net/article/details/104390689#3_Exception_69)

    - - [运行时异常](https://thinkwon.blog.csdn.net/article/details/104390689#_73)
      - [编译时异常](https://thinkwon.blog.csdn.net/article/details/104390689#_81)

    - [4. 受检异常与非受检异常](https://thinkwon.blog.csdn.net/article/details/104390689#4__89)

    - - [受检异常](https://thinkwon.blog.csdn.net/article/details/104390689#_93)
      - [非受检异常](https://thinkwon.blog.csdn.net/article/details/104390689#_97)

  - [Java异常关键字](https://thinkwon.blog.csdn.net/article/details/104390689#Java_103)

- [Java异常处理](https://thinkwon.blog.csdn.net/article/details/104390689#Java_116)

- - [声明异常](https://thinkwon.blog.csdn.net/article/details/104390689#_124)

  - [抛出异常](https://thinkwon.blog.csdn.net/article/details/104390689#_135)

  - [捕获异常](https://thinkwon.blog.csdn.net/article/details/104390689#_143)

  - [如何选择异常类型](https://thinkwon.blog.csdn.net/article/details/104390689#_149)

  - [常见异常处理方式](https://thinkwon.blog.csdn.net/article/details/104390689#_157)

  - - [直接抛出异常](https://thinkwon.blog.csdn.net/article/details/104390689#_159)
    - [封装异常再抛出](https://thinkwon.blog.csdn.net/article/details/104390689#_175)
    - [捕获异常](https://thinkwon.blog.csdn.net/article/details/104390689#_191)
    - [自定义异常](https://thinkwon.blog.csdn.net/article/details/104390689#_221)
    - [try-catch-finally](https://thinkwon.blog.csdn.net/article/details/104390689#trycatchfinally_235)
    - [try-with-resource](https://thinkwon.blog.csdn.net/article/details/104390689#trywithresource_287)

- [Java异常常见面试题](https://thinkwon.blog.csdn.net/article/details/104390689#Java_307)

- - [1. Error 和 Exception 区别是什么？](https://thinkwon.blog.csdn.net/article/details/104390689#1_Error__Exception__309)
  - [2. 运行时异常和一般异常(受检异常)区别是什么？](https://thinkwon.blog.csdn.net/article/details/104390689#2__317)
  - [3. JVM 是如何处理异常的？](https://thinkwon.blog.csdn.net/article/details/104390689#3_JVM__327)
  - [4. throw 和 throws 的区别是什么？](https://thinkwon.blog.csdn.net/article/details/104390689#4_throw__throws__335)
  - [5. final、finally、finalize 有什么区别？](https://thinkwon.blog.csdn.net/article/details/104390689#5_finalfinallyfinalize__346)
  - [6. NoClassDefFoundError 和 ClassNotFoundException 区别？](https://thinkwon.blog.csdn.net/article/details/104390689#6_NoClassDefFoundError__ClassNotFoundException__354)
  - [7. try-catch-finally 中哪个部分可以省略？](https://thinkwon.blog.csdn.net/article/details/104390689#7_trycatchfinally__364)
  - [8. try-catch-finally 中，如果 catch 中 return 了，finally 还会执行吗？](https://thinkwon.blog.csdn.net/article/details/104390689#8_trycatchfinally__catch__return_finally__378)
  - [9. 类 ExampleA 继承 Exception，类 ExampleB 继承ExampleA。](https://thinkwon.blog.csdn.net/article/details/104390689#9__ExampleA__Exception_ExampleB_ExampleA_433)
  - [10. 常见的 RuntimeException 有哪些？](https://thinkwon.blog.csdn.net/article/details/104390689#10__RuntimeException__490)
  - [11. Java常见异常有哪些](https://thinkwon.blog.csdn.net/article/details/104390689#11_Java_500)

- [Java异常处理最佳实践](https://thinkwon.blog.csdn.net/article/details/104390689#Java_536)

- - [1. 在 finally 块中清理资源或者使用 try-with-resource 语句](https://thinkwon.blog.csdn.net/article/details/104390689#1__finally__trywithresource__542)

  - - [1.1 使用 finally 代码块](https://thinkwon.blog.csdn.net/article/details/104390689#11__finally__567)
    - [1.2 Java 7 的 try-with-resource 语法](https://thinkwon.blog.csdn.net/article/details/104390689#12_Java_7__trywithresource__592)

  - [2. 优先明确的异常](https://thinkwon.blog.csdn.net/article/details/104390689#2__609)

  - [3. 对异常进行文档说明](https://thinkwon.blog.csdn.net/article/details/104390689#3__625)

  - [4. 使用描述性消息抛出异常](https://thinkwon.blog.csdn.net/article/details/104390689#4__634)

  - [5. 优先捕获最具体的异常](https://thinkwon.blog.csdn.net/article/details/104390689#5__649)

  - [6. 不要捕获 Throwable 类](https://thinkwon.blog.csdn.net/article/details/104390689#6__Throwable__671)

  - [7. 不要忽略异常](https://thinkwon.blog.csdn.net/article/details/104390689#7__688)

  - [8. 不要记录并抛出异常](https://thinkwon.blog.csdn.net/article/details/104390689#8__713)

  - [9. 包装异常时不要抛弃原始的异常](https://thinkwon.blog.csdn.net/article/details/104390689#9__747)

  - [10. 不要使用异常控制程序的流程](https://thinkwon.blog.csdn.net/article/details/104390689#10__762)

  - [11. 使用标准异常](https://thinkwon.blog.csdn.net/article/details/104390689#11__768)

  - [12. 异常会影响性能](https://thinkwon.blog.csdn.net/article/details/104390689#12__774)

  - [13. 总结](https://thinkwon.blog.csdn.net/article/details/104390689#13__786)