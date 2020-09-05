package staticproxy;

public class UserServiceImpl implements UserService {
    //开始事务 处理业务 调用dao
    @Override
    public void save(String name) {
        System.out.println("处理业务逻辑，调用DAO");
    }

    @Override
    public void delete(String id) {
        System.out.println("处理业务逻辑，调用DAO");
    }

    @Override
    public void upadate() {
        System.out.println("处理业务逻辑，调用DAO");
    }

    @Override
    public String findAll(String name) {
        System.out.println("处理业务逻辑，调用DAO");
        return name;
    }

    @Override
    public String findOne(String id) {
        System.out.println("处理业务逻辑，调用DAO");
        return id;
    }
}
