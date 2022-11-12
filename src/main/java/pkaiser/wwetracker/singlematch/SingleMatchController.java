package pkaiser.wwetracker.singlematch;

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
@RequestMapping("/single")
public class SingleMatchController {
	private SingleMatchService service;
	
	public SingleMatchController(SingleMatchService service) {
		this.service = service;
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<SingleMatch>> getAllSingleMatches() {
		List<SingleMatch> matches = service.getAllSingleMatches();
		return new ResponseEntity<>(matches,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<List<SingleMatch>> addSingleMatch(@RequestBody SingleMatch match) {
		List<SingleMatch> matches = service.createSingleMatch(match);
		return new ResponseEntity<>(matches,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<SingleMatch> getSingleMatchById(@PathVariable Long id) {
		SingleMatch match = service.getSingleMatchById(id).get();
		return new ResponseEntity<>(match,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<SingleMatch>> deleteSingleMatchById(@PathVariable Long id) {
		List<SingleMatch> match = service.deleteSingleMatchById(id);
		return new ResponseEntity<>(match,HttpStatus.OK);
	}
	
	@GetMapping("/update/{id}")
	public ResponseEntity<SingleMatch> updateSingleMatchById(@PathVariable Long id, @RequestBody SingleMatch update) {
		SingleMatch match = service.updateSingleMatchById(id, update);
		return new ResponseEntity<>(match,HttpStatus.OK);
	}
	

}
