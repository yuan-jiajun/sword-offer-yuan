package com.oj.company.oppo;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Yuan Jiajun
 * @date 2020/8/29 19:27
 * @description
 */
public class UTF8Reader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("d:\\readme.md");
        char[] buf = new char[1024];
        int num;
        while ((num = fr.read(buf)) != -1) {
            System.out.print(new String(buf, 0, num));
        }
        fr.close();
    }
}