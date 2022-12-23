package pkaiser.wwetracker.teilnehmer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TeilnehmerService {
	
	private SpielerRepo spielerRepo;
	private TagTeamRepo tagTeamRepo;
	Logger logger = LoggerFactory.getLogger(TeilnehmerController.class);
	
	public TeilnehmerService(SpielerRepo spielerRepo, TagTeamRepo tagTeamRepo) {
		this.spielerRepo = spielerRepo;
		this.tagTeamRepo = tagTeamRepo;
	}
	
	public List<SpielerModel> getAllSpieler() {
		return this.spielerRepo.findAll();
	}
	
	public List<TagTeamModel> getAllTagTeams() {
		return this.tagTeamRepo.findAll();
	}
	
	public SpielerModel getSpielerById(Long id) {
		return this.spielerRepo.findById(id).get();
	}
	
	public TagTeamModel getTagTeamById(Long id) {
		return this.tagTeamRepo.findById(id).get();
	}
	
	public SpielerModel addSpieler(SpielerModel spieler) {
		return spielerRepo.save(spieler);
	}
	
	public TagTeamModel addTagTeam(TagTeamModel tagTeam) {
		logger.info(tagTeam.toString());
		return tagTeamRepo.save(tagTeam);
	}

}
