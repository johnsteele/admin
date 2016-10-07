package uk.me.eastmans.admin.model;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by markeastman on 03/10/2016.
 */
@ApplicationScoped
public class UserMessageRepository extends CRUDRepository<UserMessage,Long> {

    public UserMessageRepository() {
        super(UserMessage.class); // I cant find a way to do this in the super class
    }

    public List getMessagesForUser(Long userId )
    {
        Query query = em.createQuery("SELECT m FROM UserMessage m WHERE m.forWho.id = :userId AND read = 0 ORDER BY id DESC");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public void clearMessages( Long userId, Long maxId )
    {
        Query query = em.createQuery("UPDATE UserMessage m SET m.read = 1 WHERE m.forWho.id = :userId AND m.id <= :maxId");
        query.setParameter("userId", userId);
        query.setParameter("maxId", maxId);
        query.executeUpdate();
    }

}
