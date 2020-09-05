package adi;

/**
 * 用来测试自动注入
 */
public class StudentServiceImpl implements StudentService {

    //自动注入
    private     StudentDAO studentDAONew;


    public void setStudentDAONew(StudentDAO studentDAONew) {
        this.studentDAONew = studentDAONew;
    }

    @Override
    public void save(String name) {
        System.out.println("Service name = " + name);
        studentDAONew.save(name);
    }
}
