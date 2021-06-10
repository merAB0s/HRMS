package hrms.dataAccess.abstracts;

import hrms.entities.concretes.LanguageCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageCandidateDao extends JpaRepository<LanguageCandidate, Integer> {

    List<LanguageCandidate> getByCandidate_Id(int candidateId);
}
