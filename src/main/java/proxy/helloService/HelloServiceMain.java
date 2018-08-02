package proxy.helloService;

/**
 * @author Administrator
 * created: 2018-06-04 15:45
 */
public class HelloServiceMain {
    public static void main(String[] args) {
        HelloServiceProxy helloHandler = new HelloServiceProxy();
        HelloService proxy = (HelloService) helloHandler.bind(new HelloServiceImpl());
        proxy.sayHello("张三");
    }
}
