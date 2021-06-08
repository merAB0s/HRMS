package hrms.dataAccess.abstracts;

import hrms.entities.concretes.AbilityCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbilityCandidatesDao extends JpaRepository<AbilityCandidate, Integer> {

    List<AbilityCandidate> getByCandidate_Id(int candidateId);
}
