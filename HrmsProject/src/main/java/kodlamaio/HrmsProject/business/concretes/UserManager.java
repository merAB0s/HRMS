package kodlamaio.HrmsProject.business.concretes;

import kodlamaio.HrmsProject.business.abstracts.UserService;
import kodlamaio.HrmsProject.business.constants.Message;
import kodlamaio.HrmsProject.core.entities.concretes.User;
import kodlamaio.HrmsProject.core.utilities.businessrules.BusinessRules;
import kodlamaio.HrmsProject.core.utilities.results.*;
import kodlamaio.HrmsProject.core.utilities.services.abstracts.EmailService;
import kodlamaio.HrmsProject.core.utilities.services.abstracts.IdentityValidationService;
import kodlamaio.HrmsProject.dataAccess.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserManager implements UserService {
    private final UserDao userDao;
    private final EmailService emailService;
    private final IdentityValidationService identityValidationService;

    @Autowired
    public UserManager(UserDao userDao, EmailService emailService, IdentityValidationService identityValidationService) {
        super();
        this.userDao = userDao;
        this.emailService = emailService;
        this.identityValidationService = identityValidationService;
    }


    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(this.userDao.findAll(), Message.AllUsersListed);
    }

    @Override
    public Result add(User user) throws Exception {
        var result = BusinessRules.RunBusinessRules(userEmailIfAlreadyExists(user),
                userNationalIdIfAlreadyExists(user),
                sendEmail());
        if (result != null) {
            return result;
        }
        validateMernis(user);
        this.userDao.save(user);
        return new SuccessResult(Message.RegisterSuccess);


    }

    @Override
    public Result delete(User user) {
        this.userDao.save(user);
        return new SuccessResult(Message.UpdateSuccess);
    }

    @Override
    public Result update(User user) {
        this.userDao.save(user);
        return new SuccessResult(Message.UpdateSuccess);
    }

    private Result userEmailIfAlreadyExists(User user) {

        for (User users : userDao.findAll()) {
            if (user.getEmail().equals(users.getEmail())) {
                return new ErrorResult(Message.ThisEmailAddressIsUsed);
            }

        }
        return new SuccessResult(Message.RegisterSuccess);
    }

    private Result userNationalIdIfAlreadyExists(User user) {

        for (User users : userDao.findAll()) {
            if (user.getNationalId().equals(users.getNationalId())) {
                return new ErrorResult(Message.ThisNationalIdIsUsed);
            }

        }
        return new SuccessResult(Message.RegisterSuccess);
    }

    private Result sendEmail() {
        if (this.emailService.sendEmail().isSuccess()) {
            return new SuccessResult(Message.EmailSend);
        }
        return new ErrorResult(Message.EmailSendingFailed);
    }

    private void validateMernis(User user) throws Exception {

        if (this.identityValidationService.validate()) {
            new SuccessResult(Message.RegisterSuccess);
            return;
        }
        new ErrorResult(Message.AuthorizationDenied);


    }
}
