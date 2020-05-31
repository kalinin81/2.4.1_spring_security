package web.DAO;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.User;

import java.util.List;

public interface UserDao {
    Long insert(String login, String password, String email);
    void update(User user);
    List<User> read();
    void delete(User user);
    void deleteAll();
    public UserDetails findByUsername(String username);

}
