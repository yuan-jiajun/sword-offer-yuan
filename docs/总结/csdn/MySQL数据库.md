### MySQL数据库

- [数据库基础知识](https://thinkwon.blog.csdn.net/article/details/104778621#_29)

- - [为什么要使用数据库](https://thinkwon.blog.csdn.net/article/details/104778621#_31)
  - [什么是SQL？](https://thinkwon.blog.csdn.net/article/details/104778621#SQL_55)
  - [什么是MySQL?](https://thinkwon.blog.csdn.net/article/details/104778621#MySQL_63)
  - [数据库三大范式是什么](https://thinkwon.blog.csdn.net/article/details/104778621#_69)
  - [mysql有关权限的表都有哪几个](https://thinkwon.blog.csdn.net/article/details/104778621#mysql_81)
  - [MySQL的binlog有有几种录入格式？分别有什么区别？](https://thinkwon.blog.csdn.net/article/details/104778621#MySQLbinlog_93)

- [数据类型](https://thinkwon.blog.csdn.net/article/details/104778621#_107)

- - [mysql有哪些数据类型](https://thinkwon.blog.csdn.net/article/details/104778621#mysql_109)

- [引擎](https://thinkwon.blog.csdn.net/article/details/104778621#_176)

- - [MySQL存储引擎MyISAM与InnoDB区别](https://thinkwon.blog.csdn.net/article/details/104778621#MySQLMyISAMInnoDB_178)
  - [MyISAM索引与InnoDB索引的区别？](https://thinkwon.blog.csdn.net/article/details/104778621#MyISAMInnoDB_209)
  - [InnoDB引擎的4大特性](https://thinkwon.blog.csdn.net/article/details/104778621#InnoDB4_218)
  - [存储引擎选择](https://thinkwon.blog.csdn.net/article/details/104778621#_230)

- [索引](https://thinkwon.blog.csdn.net/article/details/104778621#_242)

- - [什么是索引？](https://thinkwon.blog.csdn.net/article/details/104778621#_244)
  - [索引有哪些优缺点？](https://thinkwon.blog.csdn.net/article/details/104778621#_254)
  - [索引使用场景（重点）](https://thinkwon.blog.csdn.net/article/details/104778621#_268)
  - [索引有哪几种类型？](https://thinkwon.blog.csdn.net/article/details/104778621#_313)
  - [索引的数据结构（b树，hash）](https://thinkwon.blog.csdn.net/article/details/104778621#bhash_337)
  - [索引的基本原理](https://thinkwon.blog.csdn.net/article/details/104778621#_375)
  - [索引算法有哪些？](https://thinkwon.blog.csdn.net/article/details/104778621#_391)
  - [索引设计的原则？](https://thinkwon.blog.csdn.net/article/details/104778621#_412)
  - [创建索引的原则（重中之重）](https://thinkwon.blog.csdn.net/article/details/104778621#_421)
  - [创建索引的三种方式，删除索引](https://thinkwon.blog.csdn.net/article/details/104778621#_443)
  - [创建索引时需要注意什么？](https://thinkwon.blog.csdn.net/article/details/104778621#_509)
  - [使用索引查询一定能提高查询的性能吗？为什么](https://thinkwon.blog.csdn.net/article/details/104778621#_517)
  - [百万级别或以上的数据如何删除](https://thinkwon.blog.csdn.net/article/details/104778621#_527)
  - [前缀索引](https://thinkwon.blog.csdn.net/article/details/104778621#_538)
  - [什么是最左前缀原则？什么是最左匹配原则](https://thinkwon.blog.csdn.net/article/details/104778621#_550)
  - [B树和B+树的区别](https://thinkwon.blog.csdn.net/article/details/104778621#BB_558)
  - [使用B树的好处](https://thinkwon.blog.csdn.net/article/details/104778621#B_568)
  - [使用B+树的好处](https://thinkwon.blog.csdn.net/article/details/104778621#B_574)
  - [Hash索引和B+树所有有什么区别或者说优劣呢?](https://thinkwon.blog.csdn.net/article/details/104778621#HashB_580)
  - [数据库为什么使用B+树而不是B树](https://thinkwon.blog.csdn.net/article/details/104778621#BB_601)
  - [B+树在满足聚簇索引和覆盖索引的时候不需要回表查询数据，](https://thinkwon.blog.csdn.net/article/details/104778621#B_611)
  - [什么是聚簇索引？何时使用聚簇索引与非聚簇索引](https://thinkwon.blog.csdn.net/article/details/104778621#_619)
  - [非聚簇索引一定会回表查询吗？](https://thinkwon.blog.csdn.net/article/details/104778621#_632)
  - [联合索引是什么？为什么需要注意联合索引中的顺序？](https://thinkwon.blog.csdn.net/article/details/104778621#_640)

- [事务](https://thinkwon.blog.csdn.net/article/details/104778621#_654)

- - [什么是数据库事务？](https://thinkwon.blog.csdn.net/article/details/104778621#_656)
  - [事物的四大特性(ACID)介绍一下?](https://thinkwon.blog.csdn.net/article/details/104778621#ACID_666)
  - [什么是脏读？幻读？不可重复读？](https://thinkwon.blog.csdn.net/article/details/104778621#_679)
  - [什么是事务的隔离级别？MySQL的默认隔离级别是什么？](https://thinkwon.blog.csdn.net/article/details/104778621#MySQL_687)

- [锁](https://thinkwon.blog.csdn.net/article/details/104778621#_717)

- - [对MySQL的锁了解吗](https://thinkwon.blog.csdn.net/article/details/104778621#MySQL_719)
  - [隔离级别与锁的关系](https://thinkwon.blog.csdn.net/article/details/104778621#_727)
  - [按照锁的粒度分数据库锁有哪些？锁机制与InnoDB锁算法](https://thinkwon.blog.csdn.net/article/details/104778621#InnoDB_739)
  - [从锁的类别上分MySQL都有哪些锁呢？像上面那样子进行锁定岂不是有点阻碍并发效率了](https://thinkwon.blog.csdn.net/article/details/104778621#MySQL_764)
  - [MySQL中InnoDB引擎的行锁是怎么实现的？](https://thinkwon.blog.csdn.net/article/details/104778621#MySQLInnoDB_780)
  - [InnoDB存储引擎的锁的算法有三种](https://thinkwon.blog.csdn.net/article/details/104778621#InnoDB_790)
  - [什么是死锁？怎么解决？](https://thinkwon.blog.csdn.net/article/details/104778621#_806)
  - [数据库的乐观锁和悲观锁是什么？怎么实现的？](https://thinkwon.blog.csdn.net/article/details/104778621#_822)

- [视图](https://thinkwon.blog.csdn.net/article/details/104778621#_840)

- - [为什么要使用视图？什么是视图？](https://thinkwon.blog.csdn.net/article/details/104778621#_842)
  - [视图有哪些特点？](https://thinkwon.blog.csdn.net/article/details/104778621#_850)
  - [视图的使用场景有哪些？](https://thinkwon.blog.csdn.net/article/details/104778621#_873)
  - [视图的优点](https://thinkwon.blog.csdn.net/article/details/104778621#_891)
  - [视图的缺点](https://thinkwon.blog.csdn.net/article/details/104778621#_899)
  - [什么是游标？](https://thinkwon.blog.csdn.net/article/details/104778621#_909)

- [存储过程与函数](https://thinkwon.blog.csdn.net/article/details/104778621#_917)

- - [什么是存储过程？有哪些优缺点？](https://thinkwon.blog.csdn.net/article/details/104778621#_919)

- [触发器](https://thinkwon.blog.csdn.net/article/details/104778621#_947)

- - [什么是触发器？触发器的使用场景有哪些？](https://thinkwon.blog.csdn.net/article/details/104778621#_949)
  - [MySQL中都有哪些触发器？](https://thinkwon.blog.csdn.net/article/details/104778621#MySQL_963)

- [常用SQL语句](https://thinkwon.blog.csdn.net/article/details/104778621#SQL_978)

- - [SQL语句主要分为哪几类](https://thinkwon.blog.csdn.net/article/details/104778621#SQL_980)
  - [超键、候选键、主键、外键分别是什么？](https://thinkwon.blog.csdn.net/article/details/104778621#_1006)
  - [SQL 约束有哪几种？](https://thinkwon.blog.csdn.net/article/details/104778621#SQL__1015)
  - [六种关联查询](https://thinkwon.blog.csdn.net/article/details/104778621#_1027)
  - [什么是子查询](https://thinkwon.blog.csdn.net/article/details/104778621#_1152)
  - [子查询的三种情况](https://thinkwon.blog.csdn.net/article/details/104778621#_1160)
  - [mysql中 in 和 exists 区别](https://thinkwon.blog.csdn.net/article/details/104778621#mysql_in__exists__1189)
  - [varchar与char的区别](https://thinkwon.blog.csdn.net/article/details/104778621#varcharchar_1199)
  - [varchar(50)中50的涵义](https://thinkwon.blog.csdn.net/article/details/104778621#varchar5050_1225)
  - [int(20)中20的涵义](https://thinkwon.blog.csdn.net/article/details/104778621#int2020_1231)
  - [mysql为什么这么设计](https://thinkwon.blog.csdn.net/article/details/104778621#mysql_1239)
  - [mysql中int(10)和char(10)以及varchar(10)的区别](https://thinkwon.blog.csdn.net/article/details/104778621#mysqlint10char10varchar10_1245)
  - [FLOAT和DOUBLE的区别是什么？](https://thinkwon.blog.csdn.net/article/details/104778621#FLOATDOUBLE_1259)
  - [drop、delete与truncate的区别](https://thinkwon.blog.csdn.net/article/details/104778621#dropdeletetruncate_1266)
  - [UNION与UNION ALL的区别？](https://thinkwon.blog.csdn.net/article/details/104778621#UNIONUNION_ALL_1281)

- [SQL优化](https://thinkwon.blog.csdn.net/article/details/104778621#SQL_1290)

- - [如何定位及优化SQL语句的性能问题？创建的索引有没有被使用到?或者说怎么才可以知道这条语句运行很慢的原因？](https://thinkwon.blog.csdn.net/article/details/104778621#SQL_1292)
  - [SQL的生命周期？](https://thinkwon.blog.csdn.net/article/details/104778621#SQL_1370)
  - [大表数据查询，怎么优化](https://thinkwon.blog.csdn.net/article/details/104778621#_1390)
  - [超大分页怎么处理？](https://thinkwon.blog.csdn.net/article/details/104778621#_1400)
  - [mysql 分页](https://thinkwon.blog.csdn.net/article/details/104778621#mysql__1423)
  - [慢查询日志](https://thinkwon.blog.csdn.net/article/details/104778621#_1447)
  - [关心过业务系统里面的sql耗时吗？统计过慢查询吗？对慢查询都怎么优化过？](https://thinkwon.blog.csdn.net/article/details/104778621#sql_1471)
  - [为什么要尽量设定一个主键？](https://thinkwon.blog.csdn.net/article/details/104778621#_1485)
  - [主键使用自增ID还是UUID？](https://thinkwon.blog.csdn.net/article/details/104778621#IDUUID_1491)
  - [字段为什么要求定义为not null？](https://thinkwon.blog.csdn.net/article/details/104778621#not_null_1503)
  - [如果要存储用户的密码散列，应该使用什么字段进行存储？](https://thinkwon.blog.csdn.net/article/details/104778621#_1509)
  - [优化查询过程中的数据访问](https://thinkwon.blog.csdn.net/article/details/104778621#_1515)
  - [优化长难的查询语句](https://thinkwon.blog.csdn.net/article/details/104778621#_1533)
  - [优化特定类型的查询语句](https://thinkwon.blog.csdn.net/article/details/104778621#_1549)
  - [优化关联查询](https://thinkwon.blog.csdn.net/article/details/104778621#_1560)
  - [优化子查询](https://thinkwon.blog.csdn.net/article/details/104778621#_1567)
  - [优化LIMIT分页](https://thinkwon.blog.csdn.net/article/details/104778621#LIMIT_1578)
  - [优化UNION查询](https://thinkwon.blog.csdn.net/article/details/104778621#UNION_1585)
  - [优化WHERE子句](https://thinkwon.blog.csdn.net/article/details/104778621#WHERE_1591)

- [数据库优化](https://thinkwon.blog.csdn.net/article/details/104778621#_1656)

- - [为什么要优化](https://thinkwon.blog.csdn.net/article/details/104778621#_1658)

  - [数据库结构优化](https://thinkwon.blog.csdn.net/article/details/104778621#_1668)

  - [MySQL数据库cpu飙升到500%的话他怎么处理？](https://thinkwon.blog.csdn.net/article/details/104778621#MySQLcpu500_1698)

  - [大表怎么优化？某个表有近千万数据，CRUD比较慢，如何优化？分库分表了是怎么做的？分表分库了有什么问题？有用到中间件么？他们的原理知道么？](https://thinkwon.blog.csdn.net/article/details/104778621#CRUD_1710)

  - - [垂直分表](https://thinkwon.blog.csdn.net/article/details/104778621#_1736)

    - - [适用场景](https://thinkwon.blog.csdn.net/article/details/104778621#_1742)
      - [缺点](https://thinkwon.blog.csdn.net/article/details/104778621#_1747)

    - [水平分表：](https://thinkwon.blog.csdn.net/article/details/104778621#_1777)

    - - [适用场景](https://thinkwon.blog.csdn.net/article/details/104778621#_1783)
      - [水平切分的缺点](https://thinkwon.blog.csdn.net/article/details/104778621#_1788)

  - [MySQL的复制原理以及流程](https://thinkwon.blog.csdn.net/article/details/104778621#MySQL_1828)

  - [读写分离有哪些解决方案？](https://thinkwon.blog.csdn.net/article/details/104778621#_1875)

  - [备份计划，mysqldump以及xtranbackup的实现原理](https://thinkwon.blog.csdn.net/article/details/104778621#mysqldumpxtranbackup_1900)

  - [数据表损坏的修复方式有哪些？](https://thinkwon.blog.csdn.net/article/details/104778621#_1946)