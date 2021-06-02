package hrms.dataAccess.abstracts;

import hrms.entities.concretes.WorkplaceCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceCandidateDao extends JpaRepository<WorkplaceCandidate, Integer> {
}
