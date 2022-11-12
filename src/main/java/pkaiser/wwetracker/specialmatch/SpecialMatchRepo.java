package pkaiser.wwetracker.specialmatch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialMatchRepo extends JpaRepository<SpecialMatch, Long>{

}
