package hrms.dataAccess.abstracts;

import hrms.entities.concretes.Abilities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilitiesDao extends JpaRepository<Abilities, Integer> {
}
