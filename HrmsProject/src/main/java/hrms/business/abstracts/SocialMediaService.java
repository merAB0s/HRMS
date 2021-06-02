package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.SocialMedia;
import hrms.entities.concretes.Workplaces;

import java.util.List;

public interface SocialMediaService {

    DataResult<List<SocialMedia>> getAll();

    Result add(SocialMedia socialMedia);
}
