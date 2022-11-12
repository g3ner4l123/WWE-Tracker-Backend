package pkaiser.wwetracker.singlematch;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class SingleMatchService {
	private SingleMatchRepo repo;
	
	public SingleMatchService(SingleMatchRepo repo) {
		this.repo = repo;
	}
	
	public List<SingleMatch> createSingleMatch(SingleMatch match) {
		repo.save(match);
		return repo.findAll();
	}
	
	public List<SingleMatch> getAllSingleMatches() {
		return repo.findAll();
	}
	
	public Optional<SingleMatch> getSingleMatchById(Long id) {
		return repo.findById(id);
	}
	
	public List<SingleMatch> deleteSingleMatchById(Long id) {
		repo.deleteById(id);
		return repo.findAll();
	}
	
	public SingleMatch updateSingleMatchById(Long id, SingleMatch update) {
		repo.findById(id).map(oldmatch -> {
			oldmatch.setPlayerOne(update.getPlayerOne());
			oldmatch.setPlayerTwo(update.getPlayerTwo());
			oldmatch.setLeague(update.getLeague());
			oldmatch.setWeek(update.getWeek());
			oldmatch.setWinner(update.getWinner());
			oldmatch.setComment(update.getComment());
			return repo.save(oldmatch);
		});
		return repo.findById(id).get();
	}
}
