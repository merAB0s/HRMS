package hrms.dataAccess.abstracts;

import hrms.entities.concretes.LinkType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkTypeDao extends JpaRepository<LinkType, Integer> {
}
