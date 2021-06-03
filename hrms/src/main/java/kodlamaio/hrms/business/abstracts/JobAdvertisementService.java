package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService extends BaseService<JobAdvertisement> {

	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndId(int employerId);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByPublishDateDesc();
	Result setPassiveAdvertisement(int advertisementId);
}
