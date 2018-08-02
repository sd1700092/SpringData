package proxy.pattern.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * created: 2018-08-01 14:44
 */
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶。。。");
        method.invoke(target);
        System.out.printf("汽车结束行驶。。。汽车行驶时间%d毫秒\n", System.currentTimeMillis() - startTime);
        return null;
    }
}
