
package acme.features.anonymous.laljbulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.LaljBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousLaljBulletinListService implements AbstractListService<Anonymous, LaljBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousLaljBulletinRepository repository;


	// AbstractListService<Anonymous, LaljBulletin> interface --------------

	@Override
	public boolean authorise(final Request<LaljBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<LaljBulletin> request, final LaljBulletin entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "event", "momentOfEvent", "location", "euros");
	}

	@Override
	public Collection<LaljBulletin> findMany(final Request<LaljBulletin> request) {
		assert request != null;

		Collection<LaljBulletin> result;
		result = this.repository.findMany();

		return result;
	}
}
