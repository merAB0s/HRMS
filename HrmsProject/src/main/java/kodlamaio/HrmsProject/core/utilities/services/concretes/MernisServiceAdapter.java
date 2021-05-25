package kodlamaio.HrmsProject.core.utilities.services.concretes;

import kodlamaio.HrmsProject.core.utilities.services.abstracts.IdentityValidationService;
import kodlamaio.HrmsProject.core.utilities.services.mernis.QPBKPSPublicSoap;
import org.springframework.stereotype.Service;

public class MernisServiceAdapter implements IdentityValidationService {

	@Override
	public boolean validate() throws Exception {
        QPBKPSPublicSoap publicSoap = new QPBKPSPublicSoap();
        boolean validateMernis = publicSoap.TCKimlikNoDogrula(12345567891011L ,"Deneme","Deneme",1990);

        if(validateMernis){
            return true;
        }else{
            return false;
        }
		
	}

}	
