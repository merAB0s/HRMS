package hrms.business.abstracts;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.AbilityCandidate;
import hrms.entities.concretes.CvDetail;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CvDetailService {

    DataResult<List<CvDetail>> getAll();

    DataResult<CvDetail> getByCandidateId(int candidateId);

    Result add(CvDetail cvDetail);

    Result uploadPhoto(MultipartFile file,int candidateId);


}
