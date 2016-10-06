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
public class PersonRepository extends CRUDRepository<Person,Long> {
    public PersonRepository()
    {
        super(Person.class); // I cant find a way to do this in the super class
    }
}
