package kodlamaio.HrmsProject.business.abstracts;

import kodlamaio.HrmsProject.core.entities.concretes.User;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();
    Result add(User user) throws  Exception;
    Result delete(User user);
    Result update(User user);

}
