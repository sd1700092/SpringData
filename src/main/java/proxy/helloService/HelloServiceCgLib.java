package proxy.helloService;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * created: 2018-06-04 16:18
 */
public class HelloServiceCgLib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.err.println("我准备说hello");
        Object returnObj = proxy.invokeSuper(obj, args);
        System.err.println("我说过hello了");
        return returnObj;
    }

    public static void main(String[] args) {
        HelloServiceCgLib helloHandler = new HelloServiceCgLib();
        HelloService proxy = (HelloService) helloHandler.getInstance(new HelloServiceImpl());
        proxy.sayHello("张三");
    }
}
