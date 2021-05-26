package HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HrmsProject.entities.concretes.VerifyCode;

public interface VerifyCodeDao extends JpaRepository<VerifyCode, Integer>{

	VerifyCode getByVerifyCode(String Code);

}