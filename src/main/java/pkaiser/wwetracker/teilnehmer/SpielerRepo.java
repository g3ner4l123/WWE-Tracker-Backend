package pkaiser.wwetracker.teilnehmer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpielerRepo extends JpaRepository<SpielerModel, Long> {
	
}
