package pkaiser.wwetracker.titel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TitelRepo extends JpaRepository<TitelModel, Long>{

}
