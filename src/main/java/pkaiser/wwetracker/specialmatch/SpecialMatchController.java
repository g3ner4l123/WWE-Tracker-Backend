package pkaiser.wwetracker.specialmatch;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/special")
public class SpecialMatchController {
	private SpecialMatchService service;

	public SpecialMatchController(SpecialMatchService service) {
		this.service = service;
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<SpecialMatch>> getAllSpecialMatches() {
		List<SpecialMatch> matches = service.getAllSpecialMatches();
		return new ResponseEntity<>(matches,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<List<SpecialMatch>> addSpecialMatch(@RequestBody SpecialMatch match) {
		List<SpecialMatch> matches = service.createSpecialMatch(match);
		return new ResponseEntity<>(matches,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<SpecialMatch> getSpecialMatchById(@PathVariable Long id) {
		SpecialMatch match = service.getSpecialMatch(id).get();
		return new ResponseEntity<>(match,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<SpecialMatch>> deleteSpecialMatchById(@PathVariable Long id) {
		List<SpecialMatch> match = service.deleteSpecialMatchById(id);
		return new ResponseEntity<>(match,HttpStatus.OK);
	}

	@GetMapping("/update/{id}")
	public ResponseEntity<SpecialMatch> updateSpecialMatchById(@PathVariable Long id, @RequestBody SpecialMatch update) {
		SpecialMatch match = service.updateSpecialMatchById(id, update);
		return new ResponseEntity<>(match,HttpStatus.OK);
	}
	
}
