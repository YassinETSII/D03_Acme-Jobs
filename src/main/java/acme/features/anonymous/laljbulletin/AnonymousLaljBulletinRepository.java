
package acme.features.anonymous.laljbulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.LaljBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousLaljBulletinRepository extends AbstractRepository {

	@Query("select l from LaljBulletin l")
	Collection<LaljBulletin> findMany();
}
