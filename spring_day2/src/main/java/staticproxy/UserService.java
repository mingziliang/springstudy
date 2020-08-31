package staticproxy;

public interface UserService {
    void save(String name );
    void delete(String id);
    void upadate( );
    String  findAll(String name);
    String findOne(String id);
}
