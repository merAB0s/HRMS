package hrms.business.abstracts;

import hrms.core.utilities.results.Result;

public interface ActivationCodeService {

    Result sendVerificationCode(int userId);
    Result verify(String code);
}
