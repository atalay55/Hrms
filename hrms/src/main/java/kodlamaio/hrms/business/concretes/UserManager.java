package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.database.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
import lombok.var;


@Service
public class UserManager implements UserService{
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>>  getAll() {
		return new SuccessDataResult<List<User>>( userDao.findAll(),"data getirildi");
		
	}

	@Override
	public Result add(User item) {
		userDao.save(item);
		return new SuccessResult("islem basarili");
		
	}

	@Override
	public Result delete(User item) {
		userDao.delete(item);
		return new SuccessResult("islem basarili");
	}



	


//	@Override
//	public User getById(int id) {
//		
//		return userDao.getOne(id);
//	}

	@Override
	public Result checkUserExitsByEmail(String email) {

        var userEmail = getByEmail(email);
        if(userEmail.equals(null)){
           return new ErrorResult("This email address has been used before.");
        }

        return new SuccessResult();
    }

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(userDao.getByEmail(email));
	}
	}


