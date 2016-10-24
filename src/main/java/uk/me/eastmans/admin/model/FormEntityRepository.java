package uk.me.eastmans.admin.model;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by markeastman on 03/10/2016.
 */
@ApplicationScoped
public class FormEntityRepository extends CRUDRepository<FormEntity,Long> {
    public FormEntityRepository()
    {
        super(FormEntity.class); // I cant find a way to do this in the super class
    }
}
