package uk.me.eastmans.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.me.eastmans.admin.domain.FormEntity;

/**
 * Created by markeastman on 04/11/2016.
 */
public interface FormEntityRepository extends JpaRepository<FormEntity, Long> {
}
