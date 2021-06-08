package hrms.dataAccess.abstracts;

import hrms.entities.concretes.LanguageLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageLevelDao extends JpaRepository<LanguageLevel, Integer> {
}
