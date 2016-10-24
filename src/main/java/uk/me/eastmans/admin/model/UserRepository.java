package uk.me.eastmans.admin.model;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

/**
 * Created by markeastman on 03/10/2016.
 */
@ApplicationScoped
public class UserRepository extends CRUDRepository<User,Long> {
    public UserRepository()
    {
        super(User.class); // I cant find a way to do this in the super class
    }

    public User getUserWithLogin(String loginName, String password)
    {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.loginName = :name AND u.password = :password");
        query.setParameter("name", loginName);
        query.setParameter("password", password);
        return (User)query.getSingleResult();
    }
}
