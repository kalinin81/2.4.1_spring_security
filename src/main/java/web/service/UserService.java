package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserService
       // implements UserDetailsService
{

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public Long insert(String login, String password, String email) {
        return userDao.insert(login, password, email);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.read();
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Transactional
    public void deleteAll() {
        userDao.deleteAll();
    }

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //return userDao.findByUsername(username);
        return null;
    }*/
}
