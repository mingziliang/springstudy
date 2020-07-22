package init;

public class TestUserDAO {
    public static void main(String[] args) {
        //创建组件对象
        UserDAOImpl userDAO = new UserDAOImpl();
        //使用组件对象
        userDAO.save("小小");
        //销毁jvm

    }
}
