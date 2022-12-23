package pkaiser.wwetracker.titel;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/titel")
public class TitelController {
	
	private TitelService service;
	
	public TitelController(TitelService service) {
		this.service = service;
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<TitelModel>> getAllTitels() {
		List<TitelModel> titels = service.getAllTitles();
		return new ResponseEntity<List<TitelModel>>(titels, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<TitelModel> getSingleEvent(@PathVariable Long id) {
		Optional<TitelModel> titel = service.getSingleTitel(id);
		if (titel.isPresent()) {
			return new ResponseEntity<TitelModel>(titel.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<TitelModel>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<TitelModel> addSingleEvent(@RequestBody TitelModel titel) {
		TitelModel createdTitel = service.addSingleTitel(titel);
		return new ResponseEntity<TitelModel>(createdTitel, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<TitelModel> updateSingleEvent(@PathVariable Long id, @RequestBody TitelModel titel) {
		Optional<TitelModel> toUpdate = service.getSingleTitel(id);
		if (toUpdate.isPresent()) {
			TitelModel updated = service.updateTitel(id, titel);
			return new ResponseEntity<TitelModel>(updated,HttpStatus.OK);		
		} else {
			return new ResponseEntity<TitelModel>(HttpStatus.NOT_FOUND);	
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteSingleEvent(@PathVariable Long id) {
		if (service.deleteSingleTitel(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
