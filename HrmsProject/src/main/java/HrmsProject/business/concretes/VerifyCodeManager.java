package HrmsProject.business.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HrmsProject.business.abstracts.VerifyCodeService;
import HrmsProject.core.utilities.results.Result;
import HrmsProject.core.utilities.results.SuccessResult;
import HrmsProject.dataAccess.abstracts.VerifyCodeDao;
import HrmsProject.entities.concretes.User;
import HrmsProject.entities.concretes.VerifyCode;

@Service
public class VerifyCodeManager implements VerifyCodeService {
	
	private VerifyCodeDao verifyCodeDao;
	
	@Autowired
	public VerifyCodeManager(VerifyCodeDao verifyCodeDao) {
		super();
		this.verifyCodeDao = verifyCodeDao;
	}

	@Override
	public String createVerifyCode(User user) {
		String vCode = UUID.randomUUID().toString();
		
		VerifyCode Code = new VerifyCode();
		Code.setUserId(user);
		Code.setVerifyCode(UUID.randomUUID().toString());
		Code.setCreatedDate(null);
		Code.setConfirmedDate(null);
		this.verifyCodeDao.save(Code);
		
		return vCode;
	}

	@Override
	public Result sendMail(String mail) {
		System.out.println("Mail Gönderildi : " + mail);
		System.out.println("Doğrulama Linki: http://localhost:8080/valid/27/833b120a-4b62-48f7-8d83-73074fe26e2d" );
		return null;
	}

	@Override
	public Result verifyUser(String code) {
		VerifyCode newVerifyCode = verifyCodeDao.getByVerifyCode(code);
		newVerifyCode.setId(newVerifyCode.getId());
		newVerifyCode.setConfirmed(true);
		newVerifyCode.setId(newVerifyCode.getId());
		newVerifyCode.setUserId(newVerifyCode.getUserId());
		newVerifyCode.setVerifyCode(newVerifyCode.getVerifyCode());
		verifyCodeDao.save(newVerifyCode);
		return new SuccessResult("Doğrulama Başarılı");
	}

}
