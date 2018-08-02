package proxy.pattern.jdkproxy;

import proxy.pattern.Car;
import proxy.pattern.Movable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * created: 2018-08-01 14:47
 */
public class Test {
    public static void main(String[] args) {
        Movable car = new Car(); //Car一定要实现了某个接口，这里是movable 也可以写成Car car = new Car()
        InvocationHandler h = new TimeHandler(car);
        Class<? extends Movable> cls = car.getClass();

        Movable m = (Movable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h); // 变成了一个实现了Movable的对象
        m.move();
    }
}
