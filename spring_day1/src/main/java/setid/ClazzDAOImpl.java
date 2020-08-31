package setid;

public class ClazzDAOImpl implements  ClazzDAO {
    @Override
    public void save(String name) {
        System.out.println("Clazz DAO name = " + name);
    }
}
