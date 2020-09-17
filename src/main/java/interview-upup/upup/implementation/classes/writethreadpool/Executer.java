package upup.implementation.classes.writethreadpool;

/**
 * @author Yuan Jiajun
 * @date 2020/9/17 10:26
 * @description @link
 */
public interface Executer {
    /**
     * 添加工作方法
     */
    void execute(Runnable runnable);
}