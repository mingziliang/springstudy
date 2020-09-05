package staticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {
    public static void main(String[] args) {
        //动态代理对象： 指的是在程序运行过程中动态通过代码的方式为指定的类生产动态代理对象

        UserService userService = new UserServiceImpl();//目标类

        //proxy 用来生成动态对象的类

        //参数1 ： classLoader
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //参数2 :  Class[] 动态代理对象的接口的类型的数组 目标对象的接口的类型的数组
        Class[] classes= {UserService.class};

        //参数3 ： InvocationHandler 接口类型 invoke方法 用来书写额外功能 附加操作


        //返回值： 创建好的动态代理对象
        UserService userService1DynamicProxy = (UserService)Proxy.newProxyInstance(classLoader, classes, new InvocationHandler() {
            @Override
            //通过动态代理对象调用自己里面代理方法时会有限指定invokcationHandler类中invoke
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("====================");
                return null;
            }
        });

        System.out.println(userService1DynamicProxy.getClass());
        userService1DynamicProxy.save("次奥");

    }
}
