package jdktheory.stringstringbuilder;

/**
 * @author Yuan Jiajun
 * @date 2020/9/17 22:14
 * @description @link
 */
public class TestStringFinal {

    //不可变的String
    public static String appendStr(String s) {
        s += "bbb";
        return s;
    }

    //可变的StringBuilder
    public static StringBuilder appendSb(StringBuilder sb) {
        return sb.append("bbb");
    }

    public static void main(String[] args) {
        String s = new String("aaa");
        String ns = TestStringFinal.appendStr(s);
        System.out.println("String aaa>>>" + s.toString());

        //StringBuilder做参数
        StringBuilder sb = new StringBuilder("aaa");
        StringBuilder nsb = TestStringFinal.appendSb(sb);
        System.out.println("StringBuilder aaa >>>" + sb.toString());
    }

}