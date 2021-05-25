package kodlamaio.HrmsProject.business.concretes;

import kodlamaio.HrmsProject.business.abstracts.AuthService;
import kodlamaio.HrmsProject.business.constants.Message;
import kodlamaio.HrmsProject.core.entities.concretes.User;
import kodlamaio.HrmsProject.core.utilities.businessrules.BusinessRules;
import kodlamaio.HrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.HrmsProject.dataAccess.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {
    private final UserDao userDao;

    @Autowired
    public AuthManager(UserDao userDao){
        super();
        this.userDao = userDao;
    }


    @Override
    public Result login(User user) {
        var result = BusinessRules.RunBusinessRules(checkEmail(user),checkPassword(user));
        if(result != null){
            return result;
        }
        return new SuccessDataResult<>(Message.LoginSuccessful);
    }

    private Result checkEmail(User user){
        for(User auth : userDao.findAll()){
            if(user.getEmail().equals(auth.getEmail())){
                return new SuccessResult(Message.LoginSuccessful);
            }
        }
        return new ErrorResult(Message.EmailAddressIsNotRegisteredInTheSystem);
    }

    private Result checkPassword(User user){
        for(User auth : userDao.findAll()){
            if(!user.getPassword().equals(auth.getPassword())){
                return new SuccessResult(Message.LoginSuccessful);
            }
        }
        return new ErrorResult(Message.WrongPassword);
    }

}
