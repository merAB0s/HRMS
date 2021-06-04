package hrms.dataAccess.abstracts;

import hrms.entities.concretes.ActivitionCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationCodeDao extends JpaRepository<ActivitionCode, Integer>{

    ActivitionCode findByCode(String code);
}
