package hrms.dataAccess.abstracts;

import hrms.entities.concretes.CvDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvDetailDto extends JpaRepository<CvDetail, Integer> {

    CvDetail getByCandidate_Id(int candidateId);
}
