package proxy.pattern;

/**
 * @author Administrator
 * created: 2018-08-01 14:05
 */
public class CarTimeProxy implements Movable {

    private Movable m;

    public CarTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶。。。");
        m.move();
        System.out.printf("汽车结束行驶。。。汽车行驶时间%d毫秒\n", System.currentTimeMillis() - startTime);
    }
}
