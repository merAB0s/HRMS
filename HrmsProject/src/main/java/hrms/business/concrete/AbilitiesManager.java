package hrms.business.concrete;

import hrms.business.abstracts.AbilitiesService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.AbilitiesDao;
import hrms.entities.concretes.Abilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilitiesManager implements AbilitiesService {

    private AbilitiesDao abilitiesDao;

    @Autowired
    public AbilitiesManager(AbilitiesDao abilitiesDao) {
        this.abilitiesDao = abilitiesDao;
    }

    @Override
    public DataResult<List<Abilities>> getAll() {
        return new SuccessDataResult<List<Abilities>>(this.abilitiesDao.findAll(), "Yetenekler Başarıyla Listelendi.");
    }

    @Override
    public Result add(Abilities abilities) {
        abilitiesDao.save(abilities);
        return new SuccessResult("Başarıyla Yetenek Eklendi.");
    }
}
