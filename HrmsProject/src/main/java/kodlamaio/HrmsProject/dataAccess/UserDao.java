package kodlamaio.HrmsProject.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.core.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
}
