package upup.theory.shallowdeepcopy;

import java.io.Serializable;

/**
 * @author yuanjiajun
 * @date 2020/9/9 23:58
 * @description
 */
public class ColoredCircle implements Serializable {

    private int x;
    private int y;

    public ColoredCircle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}
