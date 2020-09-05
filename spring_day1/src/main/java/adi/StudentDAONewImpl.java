package adi;

public class StudentDAONewImpl implements StudentDAO {
    @Override
    public void save(String name) {
        System.out.println("NEW DAO name = " + name);
    }
}
