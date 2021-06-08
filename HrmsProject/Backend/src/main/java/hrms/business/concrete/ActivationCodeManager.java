package hrms.business.concrete;

import hrms.business.abstracts.ActivationCodeService;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.ActivationCodeDao;
import hrms.entities.concretes.ActivitionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ActivationCodeManager implements ActivationCodeService {

    @Autowired
    private ActivationCodeDao verificationCodeDao;

    @Override
    public Result sendVerificationCode(int userId) {
        verificationCodeDao.save(new ActivitionCode(userId, UUID.randomUUID().toString(), false, LocalDateTime.now()));
        return new SuccessResult("Mailinize Başarıyla Kod Gönderildi!");
    }

    @Override
    public Result verify(String code) {

        ActivitionCode verificationCode = this.verificationCodeDao.findByCode(code);
        verificationCode.setVerified(true);
        this.verificationCodeDao.save(verificationCode);
        return new SuccessResult("Başarıyla Doğrulandı!");
    }
}
