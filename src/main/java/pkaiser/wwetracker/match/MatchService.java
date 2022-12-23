package pkaiser.wwetracker.match;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;



@Service
public class MatchService {

	private MatchRepo repo;
	
	public MatchService(MatchRepo repo) {
		this.repo = repo;
	}
	
	public List<MatchModel> getAllMatches() {
		return repo.findAll();
	}
	
	public Optional<MatchModel> getSingleMatch(Long id) {
		return repo.findById(id);
	}
	
	public MatchModel addSingleMatch(MatchModel match) {

		return repo.save(match);
	}
}
