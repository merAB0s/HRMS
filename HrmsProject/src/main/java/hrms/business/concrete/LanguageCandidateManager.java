package hrms.business.concrete;

import hrms.business.abstracts.LanguageCandidateService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.LanguageCandidateDao;
import hrms.entities.concretes.LanguageCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageCandidateManager implements LanguageCandidateService {

    private LanguageCandidateDao languageCandidateDao;

    @Autowired
    public LanguageCandidateManager(LanguageCandidateDao languageCandidateDao) {
        this.languageCandidateDao = languageCandidateDao;
    }


    @Override
    public DataResult<List<LanguageCandidate>> getAll() {
        return new SuccessDataResult<List<LanguageCandidate>>(this.languageCandidateDao.findAll(),"İş Arayanların Dil ve Seviyeleri Listelendi.");
    }

    @Override
    public Result add(LanguageCandidate languageCandidate) {
        languageCandidateDao.save(languageCandidate);
        return new SuccessResult("Başarıyla Eklendi.");
    }
}
