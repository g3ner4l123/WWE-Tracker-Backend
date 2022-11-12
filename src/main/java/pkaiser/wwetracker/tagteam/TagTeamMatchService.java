package pkaiser.wwetracker.tagteam;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public class TagTeamMatchService {
	private TagTeamMatchRepo repo;

	public TagTeamMatchService(TagTeamMatchRepo repo) {
		this.repo = repo;
	}
	
	public List<TagTeamMatch> createTagTeamMatch(TagTeamMatch match) {
		repo.save(match);
		return repo.findAll();
	}
	
	public List<TagTeamMatch> getAllTagTeamMatches(){
		return repo.findAll();
	}
	
	public Optional<TagTeamMatch> getTagTeamMatch(Long id){
		return repo.findById(id);
	}
	
	public List<TagTeamMatch> deleteTagTeamMatchById(Long id) {
		repo.deleteById(id);
		return repo.findAll();
	}
	
	public TagTeamMatch updateTagTeamMatchById(Long id, TagTeamMatch update) {
		repo.findById(id).map(oldmatch -> {
			oldmatch.setTeamOne(update.getTeamOne());
			oldmatch.setTeamTwo(update.getTeamTwo());
			oldmatch.setLeague(update.getLeague());
			oldmatch.setWeek(update.getWeek());
			oldmatch.setWinner(update.getWinner());
			oldmatch.setComment(update.getComment());
			return repo.save(oldmatch);
		});
		return repo.findById(id).get();
	}
	
	
	
}
