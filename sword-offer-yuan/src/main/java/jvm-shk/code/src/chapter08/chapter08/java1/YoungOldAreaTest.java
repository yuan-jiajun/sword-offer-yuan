package chapter08.java1;

/** 测试：大对象直接进入老年代
 * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 *
 *   16：2：2：40
 * @author shkstart  shkstart@126.com
 * @create 2020  21:48
 */
public class YoungOldAreaTest {
    public static void main(String[] args) {
        byte[] buffer2 = new byte[1024 * 1024 * 10];//20m
        byte[] buffer = new byte[1024 * 1024 * 20];//20m

    }
}
