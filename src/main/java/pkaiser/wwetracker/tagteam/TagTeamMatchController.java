package pkaiser.wwetracker.tagteam;

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
@RequestMapping("/tagteam")
public class TagTeamMatchController {
	private TagTeamMatchService service;

	public TagTeamMatchController(TagTeamMatchService service) {
		this.service = service;
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<TagTeamMatch>> getAllTagTeamMatches() {
		List<TagTeamMatch> matches = service.getAllTagTeamMatches();
		return new ResponseEntity<>(matches,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<List<TagTeamMatch>> addTagTeamMatch(@RequestBody TagTeamMatch match) {
		List<TagTeamMatch> matches = service.createTagTeamMatch(match);
		return new ResponseEntity<>(matches,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<TagTeamMatch> getTagTeamMatchById(@PathVariable Long id) {
		TagTeamMatch match = service.getTagTeamMatch(id).get();
		return new ResponseEntity<>(match,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<TagTeamMatch>> deleteTagTeamMatchById(@PathVariable Long id) {
		List<TagTeamMatch> match = service.deleteTagTeamMatchById(id);
		return new ResponseEntity<>(match,HttpStatus.OK);
	}

	@GetMapping("/update/{id}")
	public ResponseEntity<TagTeamMatch> updateTagTeamMatchById(@PathVariable Long id, @RequestBody TagTeamMatch update) {
		TagTeamMatch match = service.updateTagTeamMatchById(id, update);
		return new ResponseEntity<>(match,HttpStatus.OK);
	}
}
