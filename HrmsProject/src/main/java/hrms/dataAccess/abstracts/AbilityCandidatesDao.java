package hrms.dataAccess.abstracts;

import hrms.entities.concretes.AbilityCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityCandidatesDao extends JpaRepository<AbilityCandidate, Integer> {
}
