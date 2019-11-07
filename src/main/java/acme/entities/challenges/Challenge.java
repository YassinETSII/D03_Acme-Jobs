
package acme.entities.challenges;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	private Date				deadline;

	@NotBlank
	private String				description;

	@NotBlank
	private String				goldGoal;

	@NotBlank
	private String				silverGoal;

	@NotBlank
	private String				bronzeGoal;

	@NotNull
	@Valid
	private Money				goldReward;

	@NotNull
	@Valid
	private Money				silverReward;

	@NotNull
	@Valid
	private Money				bronzeReward;

	// Derived Attributes -------------------------------------------------------

	// Relationships ------------------------------------------------------------

}
