package hrms.dataAccess.abstracts;

import hrms.entities.concretes.SchoolCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolCandidateDao extends JpaRepository<SchoolCandidate, Integer> {
}
