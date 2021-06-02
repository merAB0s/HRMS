package hrms.business.concrete;

import hrms.business.abstracts.SocialMediaService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.SocialMediaDao;
import hrms.entities.concretes.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaManager implements SocialMediaService {

    private SocialMediaDao socialMediaDao;

    @Autowired
    public SocialMediaManager(SocialMediaDao socialMediaDao) {
        this.socialMediaDao = socialMediaDao;
    }


    @Override
    public DataResult<List<SocialMedia>> getAll() {
        return new SuccessDataResult<List<SocialMedia>>(this.socialMediaDao.findAll(),"Sosyal Medyalar Başarıyla Listelendi.");
    }

    @Override
    public Result add(SocialMedia socialMedia) {
        socialMediaDao.save(socialMedia);
        return new SuccessResult("Başarıyla Eklendi.");
    }
}
