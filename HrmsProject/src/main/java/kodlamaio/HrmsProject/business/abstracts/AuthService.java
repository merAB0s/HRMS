package kodlamaio.HrmsProject.business.abstracts;

import kodlamaio.HrmsProject.core.entities.concretes.User;
import kodlamaio.HrmsProject.core.utilities.results.Result;

public interface AuthService {
    Result login(User user);
}
