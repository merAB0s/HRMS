package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Candidates;

@Repository
public interface CandidatesDao extends JpaRepository<Candidates, Integer>{
	


}
