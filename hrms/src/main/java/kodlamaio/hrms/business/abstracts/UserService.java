package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService extends BaseService<User> {

	DataResult<User> getByEmail(String email);
	Result checkUserExitsByEmail(String email);
}
