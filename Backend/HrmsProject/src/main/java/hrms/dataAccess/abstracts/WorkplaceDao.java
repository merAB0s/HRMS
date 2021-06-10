package hrms.dataAccess.abstracts;

import hrms.entities.concretes.Workplaces;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceDao extends JpaRepository<Workplaces, Integer> {
}
