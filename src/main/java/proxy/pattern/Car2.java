package proxy.pattern;

/**
 * @author Administrator
 * created: 2018-08-01 13:30
 */
public class Car2 extends Car {
    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶。。。");
        super.move();
        System.out.printf("汽车结束行驶。。。汽车行驶时间%d毫秒\n", System.currentTimeMillis() - startTime);
    }
}
