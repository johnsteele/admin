package uk.me.eastmans.admin.service;

import uk.me.eastmans.admin.model.FormEntity;
import uk.me.eastmans.admin.model.FormEntityRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by markeastman on 03/10/2016.
 */
@ApplicationScoped
public class FormEntityService {

    @Inject
    private FormEntityRepository repository;

    @Transactional
    public void test()
    {
        FormEntity entity = new FormEntity();
        repository.create(entity);
    }

}
