package uk.me.eastmans.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uk.me.eastmans.admin.domain.UserMessage;

import java.util.List;

/**
 * Created by markeastman on 04/11/2016.
 */
public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {
    @Query("SELECT m FROM UserMessage m WHERE m.forWho.id = :userId AND read = 0 ORDER BY id DESC")
    public List<UserMessage> findMessagesForUser(@Param("userId") Long userId);

    @Modifying
    @Query("UPDATE UserMessage m SET m.read = 1 WHERE m.forWho.id = :userId AND m.id <= :maxId")
    public int clearMessagesForUser(@Param("userId") Long userId, @Param("maxId") Long maxId);
}
