package kodlamaio.HrmsProject.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HrmsProject.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer> {

}
