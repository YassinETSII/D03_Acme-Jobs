
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(a) from Announcement a")
	Integer numberAnnouncements();

	@Query("select count(c) from CompanyRecord c")
	Integer numberCompanyRecords();

	@Query("select count(i) from InvestorRecord i")
	Integer numberInvestorRecords();

	@Query("select min(r.reward.amount) from Request r where r.deadline > CURRENT_DATE")
	Double minimumNumberOfRewardsOfActiveRequests();

	@Query("select max(r.reward.amount) from Request r where r.deadline > CURRENT_DATE")
	Double maximumNumberOfRewardsOfActiveRequests();

	@Query("select avg(r.reward.amount) from Request r where r.deadline > CURRENT_DATE")
	Double averageNumberOfRewardsOfActiveRequests();

	@Query("select stddev(r.reward.amount) from Request r where r.deadline > CURRENT_DATE")
	Double standardDesviationNumberOfRewardsOfActiveRequests();

	@Query("select min((o.minReward.amount+o.maxReward.amount)/2) from Offer o where o.deadline > CURRENT_DATE")
	Double minimumNumberOfRewardsOfActiveOffers();

	@Query("select max((o.minReward.amount+o.maxReward.amount)/2) from Offer o where o.deadline > CURRENT_DATE")
	Double maximumNumberOfRewardsOfActiveOffers();

	@Query("select avg((o.minReward.amount+o.maxReward.amount)/2) from Offer o where o.deadline > CURRENT_DATE")
	Double averageNumberOfRewardsOfActiveOffers();

	@Query("select stddev((o.minReward.amount+o.maxReward.amount)/2) from Offer o where o.deadline > CURRENT_DATE")
	Double standardDesviationNumberOfRewardsOfActiveOffers();

}
