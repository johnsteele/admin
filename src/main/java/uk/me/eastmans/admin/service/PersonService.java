package uk.me.eastmans.admin.service;

import uk.me.eastmans.admin.model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by markeastman on 03/10/2016.
 */
@ApplicationScoped
public class PersonService {

    @Inject
    private PersonRepository personRepository;

    @Transactional
    public void test()
    {
        Person person = new Person();
        person.setName("ana");
        personRepository.create(person);
        System.out.println("ana has id " + person.getId());

        Person p = personRepository.read(1L);
        System.out.println("Person with id=1 is " + p.getName());
    }

}
