package pkaiser.wwetracker.teilnehmer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/teilnehmer")
public class TeilnehmerController {
	
	Logger logger = LoggerFactory.getLogger(TeilnehmerController.class);
	
	private TeilnehmerService service;
	
	public TeilnehmerController( TeilnehmerService service) {
		this.service = service;
	}
	
	@GetMapping("/get/spieler/all")
	public ResponseEntity<List<SpielerModel>> getAllSpieler() {
		logger.info("Received Get Call in /get/spieler/all");
		List<SpielerModel> spieler = service.getAllSpieler();
		return new ResponseEntity<List<SpielerModel>>(spieler, HttpStatus.OK);
	}
	
	@GetMapping("/get/tagTeam/all")
	public ResponseEntity<List<TagTeamModel>> getAllTagTeams() {
		List<TagTeamModel> tagTeams = service.getAllTagTeams();
		return new ResponseEntity<List<TagTeamModel>>(tagTeams, HttpStatus.OK);
	}
	
	@GetMapping("/get/spieler/{id}")
	public ResponseEntity<SpielerModel> getSpielerById(@PathVariable Long id) {
		SpielerModel spieler = service.getSpielerById(id);
		return new ResponseEntity<SpielerModel>(spieler, HttpStatus.OK);
	}
	
	@GetMapping("/get/tagTeam/{id}")
	public ResponseEntity<TagTeamModel> getTagTeamById(@PathVariable Long id) {
		TagTeamModel tagTeam = service.getTagTeamById(id);
		return new ResponseEntity<TagTeamModel>(tagTeam, HttpStatus.OK);
	}
	
	@PostMapping("/add/tagTeam")
	public ResponseEntity<TagTeamModel> addSingleTagTeam(@RequestBody TagTeamModel tagTeam) {
		logger.info("Received Get Call in /add/tagTeam");
		TagTeamModel createdTeam = service.addTagTeam(tagTeam);
		return new ResponseEntity<TagTeamModel>(createdTeam, HttpStatus.OK);
	}
	
	@PostMapping("/add/spieler")
	public ResponseEntity<SpielerModel> addSingleSpieler(@RequestBody SpielerModel spieler) {
		logger.info("Received Get Call in /get/spieler/all with: " + spieler.toString() );
		SpielerModel createdTeam = service.addSpieler(spieler);
		return new ResponseEntity<SpielerModel>(createdTeam, HttpStatus.OK);
	}
}
