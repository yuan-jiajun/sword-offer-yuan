package chapter08.java2;

/**
 * 逃逸分析
 *
 * 如何快速的判断是否发生了逃逸分析
 *
 * 大家就看new的 对象实体 是否有可能在方法外被调用。
 *
 * @create 2020 下午 4:00
 */
public class EscapeAnalysis {

    public EscapeAnalysis obj;

    /*
    方法返回EscapeAnalysis对象
    发生逃逸
     */
    public EscapeAnalysis getInstance() {
        return obj == null ? new EscapeAnalysis() : obj;
    }


    /*
    为成员属性赋值
    发生逃逸
     */
    public void setObj() {
        this.obj = new EscapeAnalysis();
    }
    //思考：如果当前的obj引用声明为static的？仍然会发生逃逸。只要传出去了，就可能会发生逃逸


    /*
    对象的作用域仅在当前方法中有效\
    没有发生逃逸
     */
    public void useEscapeAnalysis() {
        EscapeAnalysis e = new EscapeAnalysis();
    }

    /*
    引用成员变量的值，发生逃逸
     */
    public void useEscapeAnalysis1() {

        //逃逸来的对象
        EscapeAnalysis e = getInstance();

        //getInstance().xxx()同样会发生逃逸
    }
}
