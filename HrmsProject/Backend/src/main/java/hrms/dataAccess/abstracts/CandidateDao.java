package hrms.dataAccess.abstracts;

import hrms.entities.concretes.SchoolCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

import hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {


}
