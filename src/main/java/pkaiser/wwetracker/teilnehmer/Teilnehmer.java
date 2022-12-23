package pkaiser.wwetracker.teilnehmer;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pkaiser.wwetracker.match.MatchModel;
import pkaiser.wwetracker.utils.TeilnehmerType;

@Inheritance
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Teilnehmer implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String anmerkung;
	@ManyToMany()
	private Set<MatchModel> matches;
	private TeilnehmerType type;
	

}