package proxy.helloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * created: 2018-06-04 15:35
 */
public class HelloServiceProxy implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("####################我是JDK动态代理#######################");
        Object result = null;
        System.err.println("我准备说Hello.");
        result = method.invoke(target, args);
        System.err.println("我说过hello了");
        return result;
    }

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    
}
