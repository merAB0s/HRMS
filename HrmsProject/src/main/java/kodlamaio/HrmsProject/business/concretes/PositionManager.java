package kodlamaio.HrmsProject.business.concretes;

import kodlamaio.HrmsProject.business.abstracts.PositionService;
import kodlamaio.HrmsProject.business.constants.Message;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.HrmsProject.dataAccess.PositionDao;
import kodlamaio.HrmsProject.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionManager implements PositionService {
    private final PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao){
        super();
        this.positionDao = positionDao;
    }


    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<List<Position>>(this.positionDao.findAll(), Message.DataListed);
    }
}
