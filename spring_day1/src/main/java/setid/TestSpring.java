package setid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("setdi/spring.xml");
        //获取对象
        ClazzService clazzService = (ClazzService)context.getBean("clazzService");

        clazzService.save("小陈");



    }
}
