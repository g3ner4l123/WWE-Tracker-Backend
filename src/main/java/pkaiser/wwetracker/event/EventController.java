package pkaiser.wwetracker.event;

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
@RequestMapping("/event")
public class EventController {
	
	private EventService service;
	
	public EventController(EventService service) {
		this.service = service;
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<EventModel>> getAllEvents() {
		List<EventModel> events = service.getAllEvents();
		return new ResponseEntity<List<EventModel>>(events, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<EventModel> getSingleEvent(@PathVariable Long id) {
		Optional<EventModel> event = service.getSingleEvent(id);
		if (event.isPresent()) {
			return new ResponseEntity<EventModel>(event.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<EventModel>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<EventModel> addSingleEvent(@RequestBody EventModel event) {
		EventModel createdEvent = service.addSingleEvent(event);
		return new ResponseEntity<EventModel>(createdEvent, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<EventModel> updateSingleEvent(@PathVariable Long id, @RequestBody EventModel event) {
		Optional<EventModel> toUpdate = service.getSingleEvent(id);
		if (toUpdate.isPresent()) {
			EventModel updated = service.updateSingleEvent(id, event);
			return new ResponseEntity<EventModel>(updated,HttpStatus.OK);		
		} else {
			return new ResponseEntity<EventModel>(HttpStatus.NOT_FOUND);	
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteSingleEvent(@PathVariable Long id) {
		if (service.deleteSingleEvent(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
