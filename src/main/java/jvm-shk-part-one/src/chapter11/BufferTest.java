package chapter11;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * IO                  NIO (New IO / Non-Blocking IO)
 * Stream              Channel
 * byte[] / char[]     Buffer
 * <p>
 * 查看直接内存的占用与释放
 *
 * @create 2020  0:22
 */
public class BufferTest {
    private static final int BUFFER = 1024 * 1024 * 1024 * 1;//1GB

    public static void main(String[] args) {
        System.out.println(BUFFER);
        //直接分配本地内存空间
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
        System.out.println("直接内存分配完毕，请求指示！");

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("直接内存开始释放！");
        byteBuffer = null;
        System.gc();
        scanner.next();
    }
}
