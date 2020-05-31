package web.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserHibernateDao implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public UserDetails findByUsername(String login) {
        Session currentSession = sessionFactory.getCurrentSession();
        TypedQuery<User> query= currentSession.createQuery("from User where login = :login");
        query.setParameter("login", login);
        User singleResult = query.getSingleResult();
        return singleResult;
    }

    @Override
    public Long insert(String login, String password, String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        return (Long) currentSession.save(new User(login, password, email));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> read() {
        Session currentSession = sessionFactory.getCurrentSession();
        TypedQuery<User> query= currentSession.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void update(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(user);
    }

    @Override
    public void delete(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(user);
    }
    @Override
    public void deleteAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<User> users = currentSession.createQuery("from User").getResultList();
        for (User user : users) {
            currentSession.delete(user);
        }
    }

}
