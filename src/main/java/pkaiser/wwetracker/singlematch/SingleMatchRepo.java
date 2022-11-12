package pkaiser.wwetracker.singlematch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleMatchRepo extends JpaRepository<SingleMatch, Long>{
	

}
