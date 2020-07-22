package di;

public class DeptServiceImpl implements DeptService{
    private DeptDAO deptDao;

    public void setDeptDao(DeptDAO deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public void save(String name) {
        System.out.println("Dept Service name = " + name);
        deptDao.save(name);
    }
}
