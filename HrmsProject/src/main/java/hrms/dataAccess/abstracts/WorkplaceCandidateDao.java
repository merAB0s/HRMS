package hrms.dataAccess.abstracts;

import hrms.entities.concretes.WorkplaceCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkplaceCandidateDao extends JpaRepository<WorkplaceCandidate, Integer> {

    List<WorkplaceCandidate> getByCandidate_Id(int candidateId);
}
