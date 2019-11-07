
package acme.entities.investorRecords;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InvestorRecord extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				investor;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				statement;

	@Min(0)
	@Max(5)
	private Integer				stars;

	// Derived Attributes -------------------------------------------------------

	// Relationships ------------------------------------------------------------

}
