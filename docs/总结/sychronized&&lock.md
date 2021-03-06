

 ###  1. synchronized 的含义：

1. Java中每一个对象都可以成为一个监视器(Monitor), 该 Monitor由一个锁(lock),一个等待队列(阻塞队列)(waiting queue),一个入口队列 (同步队列)(entry queue).
2. 对于一个对象的方法， 如果没有synchronized关键字， 该方法可以被任意数量的线程，在任意时刻调用。
3. 对于添加了synchronized关键字的方法，任意时刻只能被唯一的一个获得了对象实例锁的线程调用。
4. synchronized用于实现多线程的同步操作
5. 如果在父类中的某个方法使用了synchronized关键字，而在子类中覆盖了这个方法，在子类中的这个方法默认情况下并不是同步的，而必须显式地在子类的这个方法中加上synchronized关键字才可以。

**因 wait()而导致阻塞的线程是放在阻塞队列中的，因竞争失败导致的阻塞是放在同步队列中的，notify()/notifyAll()实质上是把阻塞队列中的线程放到同步队列中去**



### 2. wait()功用:释放当前对象锁，并进入阻塞队列（等待队列）

1. wait(), notify(), notifyAll() 和 synchonized 需要搭配使用, 用于线程同步
2. wait()总是在一个循环中被调用，挂起当前线程来等待一个条件的成立。 wait调用会一直等到其他线程调用notifyAll()时才返回。
3. 当一个线程在执行synchronized 的方法内部，调用了wait()后，该线程会释放该对象的锁，然后该线程会被添加到该对象的等待队列中(waiting queue), 只要该线程在等待队列中， 就会一直处于闲置状态， 不会被调度执行。

**要注意wait()方法会强迫线程先进行释放锁操作，所以在调用wait()时， 该线程必须已经获得锁，否则会抛出异常。由于wait()在synchonized的方法内部被执行， 锁一定已经获得，就不会抛出异常了。**



### 3. notify()的功用:唤醒当前对象阻塞队列里的任一线程（并不保证唤醒哪一个）

1. wait(), notify(), notifyAll() 和 synchonized 需要搭配使用， 用于线程同步

2. 当一个线程调用一个对象的notify()方法时， 调度器会从所有处于该对象等待队列(waiting queue)的线程中取出任意一个线程， 将其添加到入口队列( entry queue) 中. 然后在入口队列中的多个线程就会竞争对象的锁， 得到锁的线程就可以继续执行。 如果等待队列中（waiting queue）没有线程， notify()方法不会产生任何作用

3. notifyAll() 和notify()工作机制一样， 区别在于notifyAll()会将等待队列(waiting queue)中所有的线程都添加到入口队列中（entry queue）

   **注意, notifyAll()比notify()更加常用， 因为notify()方法只会唤起一个线程，且无法指定唤醒哪一个线程，所以只有在多个执行相同任务的线程在并发运行时，我们不关心哪一个线程被唤醒时，才会使用notify()**



#### 总结

1. 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，则它取得的锁是对象；如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。
2. 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。
3. 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。



### synchronized用于静态方法和普通方法区别

- 所有的非静态同步方法用的都是同一把锁——实例对象本身

  - 也就是说如果一个实例对象的非静态同步方法获取锁后，该实例对象的其他非静态同步方法必须等待获取锁的方法释放锁后才能获取锁

  - 可是别的实例对象的非静态同步方法因为跟该实例对象的非静态同步方法用的是不同的锁，所以毋须等待该实例对象已获取锁的非静态同步方法释放锁就可以获取他们自己的锁。
- 所有的静态同步方法用的也是同一把锁——类对象本身
  
  - 这两把锁是两个不同的对象，所以静态同步方法与非静态同步方法之间是不会有竞态条件的。但是一旦一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取锁，而不管是同一个实例对象的静态同步方法之间，还是不同的实例对象的静态同步方法之间，**只要它们都是同一个类的实例对象！**
  
    

###  synchronized底层实现 && 锁的升级降级

![](<../imgs/classHead.png>)

![](<../imgs/lockupdate.png>)