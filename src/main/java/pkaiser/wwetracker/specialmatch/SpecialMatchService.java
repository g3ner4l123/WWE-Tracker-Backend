package pkaiser.wwetracker.specialmatch;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SpecialMatchService {
	private SpecialMatchRepo repo;

	public SpecialMatchService(SpecialMatchRepo repo) {
		this.repo = repo;
	}
	
	public List<SpecialMatch> createSpecialMatch(SpecialMatch match) {
		repo.save(match);
		return repo.findAll();
	}
	
	public List<SpecialMatch> getAllSpecialMatches(){
		return repo.findAll();
	}
	
	public Optional<SpecialMatch> getSpecialMatch(Long id){
		return repo.findById(id);
	}
	
	public List<SpecialMatch> deleteSpecialMatchById(Long id) {
		repo.deleteById(id);
		return repo.findAll();
	}
	
	public SpecialMatch updateSpecialMatchById(Long id, SpecialMatch update) {
		repo.findById(id).map(oldmatch -> {
			oldmatch.setPlayers(update.getPlayers());
			oldmatch.setLeague(update.getLeague());
			oldmatch.setWinner(update.getWinner());
			oldmatch.setComment(update.getComment());
			return repo.save(oldmatch);
		});
		return repo.findById(id).get();
	}	
	
	

}
