package HrmsProject.adapters.api;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import HrmsProject.adapters.service.VerifyApiService;
import HrmsProject.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements VerifyApiService<Candidate> {
		
	@Override
	public boolean ApiControl(Candidate candidate) {
		KPSPublicSoap kpsPublic;
		try {
			kpsPublic = new KPSPublicSoapProxy();
			boolean durum = kpsPublic.TCKimlikNoDogrula(
					Long.parseLong(candidate.getNationalIdentity()), 
							candidate.getName().toUpperCase(), 
							candidate.getSurname().toUpperCase(), 
							Integer.parseInt(candidate.getBirth_year()));
			return durum;
		} catch (RemoteException | NumberFormatException e1) {
			e1.printStackTrace();
		}
			return false;
	}

}
