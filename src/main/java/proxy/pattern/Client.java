package proxy.pattern;

/**
 * @author Administrator
 * created: 2018-08-01 13:12
 */
public class Client {
    public static void main(String[] args) {
        // 原生方式
//        Car car = new Car();
//        car.move();
        // 使用继承方式
//        Movable m2 = new Car2();
//        m2.move();
        // 使用聚合方式
//        Car car = new Car();
//        Movable m3 = new Car3(car);
//        m3.move();
        Car car = new Car();
        CarLogProxy clp = new CarLogProxy(car);
        CarTimeProxy ctp = new CarTimeProxy(clp);
        ctp.move();
    }
}
