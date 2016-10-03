package uk.me.eastmans.admin.model;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

/**
 * Created by markeastman on 03/10/2016.
 */
@ApplicationScoped
public class PersonRepository {

    @PersistenceContext(unitName = "Admin") // default type is PersistenceContextType.TRANSACTION
    private EntityManager em;

    public void create(Person p)
    {
        em.persist(p);
    }

    public Person findWithId(Integer id)
    {
        return em.find(Person.class, id);
    }
}
