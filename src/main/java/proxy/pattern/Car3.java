package proxy.pattern;

/**
 * @author Administrator
 * created: 2018-08-01 13:36
 */
public class Car3 implements Movable {

    private Car car;

    Car3(Car car) {
        super();
        this.car = car;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶。。。");
        car.move();
        System.out.printf("汽车结束行驶。。。汽车行驶时间%d毫秒\n", System.currentTimeMillis() - startTime);
    }
}
