package uk.me.eastmans.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.me.eastmans.admin.domain.User;

import java.util.Optional;

/**
 * Created by markeastman on 04/11/2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByLoginName(String loginName);
}
