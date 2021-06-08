package hrms.business.concrete;

import hrms.business.abstracts.LanguageLevelService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.LanguageLevelDao;
import hrms.entities.concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageLevelManager implements LanguageLevelService {

    private LanguageLevelDao languageLevelDao;

    @Autowired
    public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
        this.languageLevelDao = languageLevelDao;
    }


    @Override
    public DataResult<List<LanguageLevel>> getAll() {
        return new SuccessDataResult<List<LanguageLevel>>(this.languageLevelDao.findAll(),"İş Arayanlar İçin Dil Seviyeleri Listelendi.");
    }

    @Override
    public Result add(LanguageLevel languageLevel) {
        languageLevelDao.save(languageLevel);
        return new SuccessResult("Başarıyla Eklendi.");
    }
}
