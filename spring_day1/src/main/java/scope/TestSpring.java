package scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ApplicationContext context = new ClassPathXmlApplicationContext("scope/spring.xml");
        TagDAO tagDAO = (TagDAO) context.getBean("tagDAO");
//        System.out.println("tagDAO = " + tagDAO);
         TagDAO tagDAO1 = (TagDAO) context.getBean("tagDAO");
//        System.out.println("tagDAO = " + tagDAO1);
//        System.out.println(tagDAO==tagDAO1);
//        //工厂原理
//        TagDAO o = (TagDAO) Class.forName("scope.TagDAOImpl").newInstance();
//        System.out.println("o = " + o);

        //关闭工厂
        ((ClassPathXmlApplicationContext)context).close();
    }
}
