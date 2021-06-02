package hrms.business.concrete;

import hrms.business.abstracts.LinkTypeService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.LinkTypeDao;
import hrms.entities.concretes.LinkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkTypeManager implements LinkTypeService {

    private LinkTypeDao linkTypeDao;

    @Autowired
    public LinkTypeManager(LinkTypeDao linkTypeDao) {
        this.linkTypeDao = linkTypeDao;
    }


    @Override
    public DataResult<List<LinkType>> getAll() {
        return new SuccessDataResult<List<LinkType>>(this.linkTypeDao.findAll(),"Başarıyla Listelendi.");
    }

    @Override
    public Result add(LinkType linkType) {
        linkTypeDao.save(linkType);
        return new SuccessResult("Başarıyla Eklendi.");
    }
}
