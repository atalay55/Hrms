package kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.google.common.base.Optional;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService extends BaseService<User> {

	Result checkUserExitsByEmail(String email);
}
