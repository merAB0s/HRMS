package hrms.dataAccess.abstracts;

import hrms.entities.concretes.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
}
