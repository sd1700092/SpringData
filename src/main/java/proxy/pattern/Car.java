package proxy.pattern;

import java.util.Random;

/**
 * @author Administrator
 * created: 2018-08-01 13:09
 */
public class Car implements Movable {

    @Override
    public void move() {
//        long startTime = System.currentTimeMillis();
//        System.out.println("汽车开始行驶。。。");
        // 实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.printf("汽车结束行驶。。。汽车行驶时间%d毫秒\n", System.currentTimeMillis() - startTime);
    }
}
