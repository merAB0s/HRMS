package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.LinkType;

import java.util.List;

public interface LinkTypeService {

    DataResult<List<LinkType>> getAll();

    Result add(LinkType linkType);
}
