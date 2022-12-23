package pkaiser.wwetracker.teilnehmer;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pkaiser.wwetracker.match.MatchModel;
import pkaiser.wwetracker.utils.TeilnehmerType;


@Getter
@Setter
@Entity
public class SpielerModel extends Teilnehmer {

	@ManyToOne
	@JoinColumn(name="tag_team_id")
	private TagTeamModel team;
}
