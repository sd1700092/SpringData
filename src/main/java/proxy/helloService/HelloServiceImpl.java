package proxy.helloService;

/**
 * @author Administrator
 * created: 2018-06-04 15:03
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.err.println("Hello " + name);
    }
}
