package pkaiser.wwetracker.tagteam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagTeamMatchRepo extends JpaRepository<TagTeamMatch, Long>{

}
