package pkaiser.wwetracker.titel;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class TitelService {
	
	private TitelRepo repo;
	
	public TitelService(TitelRepo repo) {
		this.repo = repo;
	}
	
	public List<TitelModel> getAllTitles() {
		return repo.findAll();
	}
	
	public Optional<TitelModel> getSingleTitel(Long id) {
		return repo.findById(id);
	}
	
	public TitelModel addSingleTitel(TitelModel titel) {
		return repo.save(titel);
	}
	
	public TitelModel updateTitel(Long id,TitelModel titel) {
		TitelModel toUpdate =repo.findById(id).get();
		toUpdate.setName(titel.getName());
		return repo.save(toUpdate);
		
	}
	
	public Boolean deleteSingleTitel(Long id) {
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	

}
