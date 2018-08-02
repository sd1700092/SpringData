package proxy.pattern;

/**
 * @author Administrator
 * created: 2018-08-01 13:56
 */
public class CarLogProxy implements Movable {

    private Movable m;

    public CarLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("日志开始。。。");
        m.move();
        System.out.println("日志结束。。。");
    }
}
