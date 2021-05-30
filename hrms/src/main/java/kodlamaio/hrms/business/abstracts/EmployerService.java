package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService extends BaseService<Employer> {

	 Result checkEmailIsCompatibleWithDomain(Employer employer);

	 
}
