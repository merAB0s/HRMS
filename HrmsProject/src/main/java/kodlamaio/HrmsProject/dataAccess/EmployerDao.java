package kodlamaio.HrmsProject.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
