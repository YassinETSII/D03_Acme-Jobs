
package acme.features.administrator.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AdministratorChallengeRepository repository;


	// AbstractCreateService<Administrator, Challenge> interface --------------

	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "goldGoal", "silverGoal", "bronzeGoal", "goldReward", "silverReward", "bronzeReward");
	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		assert request != null;
		Challenge result;
		result = new Challenge();
		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		//TODO:validar campos
		//deadline último

		boolean acceptedBronzeCurrency, acceptedSilverCurrency, acceptedGoldCurrency, sequentialRangeAmount;
		String bronzeCurrency, silverCurrency, goldCurrency;
		Double bronzeAmount, silverAmount, goldAmount;

		if (!errors.hasErrors("goldReward")) { //Check if goldReward has no errors
			goldCurrency = entity.getGoldReward().getCurrency();
			acceptedGoldCurrency = goldCurrency.equals("EUR");
			errors.state(request, acceptedGoldCurrency, "goldReward", "administrator.challenge.error.goldCurrency");
		}

		if (!errors.hasErrors("silverReward")) { //Check if silverReward has no errors
			silverCurrency = entity.getSilverReward().getCurrency();
			acceptedSilverCurrency = silverCurrency.equals("EUR");
			errors.state(request, acceptedSilverCurrency, "silverReward", "administrator.challenge.error.silverCurrency");
		}

		if (!errors.hasErrors("bronzeReward")) { //Check if bronzeReward has no errors
			bronzeCurrency = entity.getBronzeReward().getCurrency();
			acceptedBronzeCurrency = bronzeCurrency.equals("EUR");
			errors.state(request, acceptedBronzeCurrency, "bronzeReward", "administrator.challenge.error.bronzeCurrency");
		}

		//Check if ranges of rewards are sequential
		if (!errors.hasErrors("bronzeReward")) { //Check if bronzeReward has no errors
			bronzeAmount = entity.getBronzeReward().getAmount();
			silverAmount = entity.getSilverReward().getAmount();
			sequentialRangeAmount = bronzeAmount < silverAmount;
			errors.state(request, sequentialRangeAmount, "bronzeReward", "administrator.challenge.error.rangeAmount");
		}
	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
