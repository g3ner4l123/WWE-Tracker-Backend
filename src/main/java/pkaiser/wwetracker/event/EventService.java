package pkaiser.wwetracker.event;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EventService {
	
	private EventRepo repo;

	public EventService(EventRepo repo) {
		this.repo = repo;
	}
	
	public List<EventModel> getAllEvents() {
		return repo.findAll();
	}
	
	public Optional<EventModel> getSingleEvent(Long id) {
		return repo.findById(id);
	}
	
	public EventModel addSingleEvent(EventModel event) {
		return repo.save(event);
	}
	
	public EventModel updateSingleEvent(Long id, EventModel event) {
		EventModel toUpdate = repo.findById(id).get();
		toUpdate.setName(event.getName());
		toUpdate.setWeek(event.getWeek());
		toUpdate.setMatches(event.getMatches());
		toUpdate.setType(event.getType());
		return repo.save(toUpdate);	
	}
	
	public Boolean deleteSingleEvent(Long id) {
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
}
