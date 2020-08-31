package scope;

public class TagDAOImpl implements  TagDAO {
    @Override
    public void save(String name) {
        System.out.println("DAO name :" + name);
    }
    public void  init2001(){
        System.out.println("组件对象初始化");

    }
    public  void  destory(){
        System.out.println("组件对象销毁");
    }
}
