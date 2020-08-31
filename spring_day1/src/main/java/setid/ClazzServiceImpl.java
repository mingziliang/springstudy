package setid;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ClazzServiceImpl implements  ClazzService {
    //需要组件 依赖组件 //set方式注入
    private  ClazzDAO clazzDAO;
    //SET注入语法
    private String name;
    private  Integer age;
    private  boolean sex;
    private  double price;
    private Float counts;
    private Date bir;
    //注入数组
    private  String[] qqe;
    private  ClazzDAO[] clazzDAOS;
    //注入list集合
    private List<String> hobbies;
    //注入map
    private Map<String, String> maps;
    //properties
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setClazzDAOS(ClazzDAO[] clazzDAOS) {
        this.clazzDAOS = clazzDAOS;
    }

    public void setQqe(String[] qqe) {
        this.qqe = qqe;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCounts(Float counts) {
        this.counts = counts;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //提供set方式
    public void setClazzDAO(ClazzDAO clazzDAO) {
        this.clazzDAO = clazzDAO;
    }




    @Override
    public void save(String name) {

        System.out.println("Clazz Service name = " + name);
        clazzDAO.save(name);
        System.out.println("Name : " + this.name);
        System.out.println("Age:"+this.age);
        System.out.println("Sex："+this.sex);
        System.out.println("price："+this.price);
        System.out.println("counts:"+this.counts);
        System.out.println("bir:"+this.bir);
        System.out.println("=======遍历数组=======");
        for (String s : qqe) {
            System.out.println("s = " + s);
        }
        for (ClazzDAO dao : clazzDAOS) {
            System.out.println("dao = " + dao);
        }
        hobbies.forEach(hobbies-> System.out.println("hobbies = " + hobbies));
        maps.forEach((key,value)-> System.out.println("key = " + key+"  value="+value));
        properties.forEach((key,value)-> System.out.println("key = " + key+" value="+value));
    }
}
