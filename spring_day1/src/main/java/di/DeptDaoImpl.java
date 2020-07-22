package di;

public class DeptDaoImpl implements DeptDAO {
    @Override
    public void save(String name) {
        System.out.println("DAO name = " + name);
    }
}
