package hrms.dataAccess.abstracts;

import hrms.entities.concretes.LanguageCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageCandidateDao extends JpaRepository<LanguageCandidate, Integer> {
}
