//单个java文件部署到centos 不能加入包信息
//package serverdeploy;

import java.util.concurrent.TimeUnit;

/**
 * @author Yuan Jiajun
 * @description
 * @date 2020/7/10 16:06
 */
public class ProcessorCount {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println(Runtime.getRuntime().availableProcessors());
            TimeUnit.SECONDS.sleep(2);
        }
    }
}