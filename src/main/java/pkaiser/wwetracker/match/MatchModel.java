package pkaiser.wwetracker.match;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pkaiser.wwetracker.event.EventModel;
import pkaiser.wwetracker.teilnehmer.SpielerModel;
import pkaiser.wwetracker.teilnehmer.Teilnehmer;
import pkaiser.wwetracker.titel.TitelModel;
import pkaiser.wwetracker.utils.MatchType;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Teilnehmer gewinner;
	@ManyToMany
	private Set<SpielerModel> teilnehmer;
	private String anmerkung;
    @ManyToOne
    @JoinColumn(name="titelmodel_id")
	private TitelModel titel;
    private MatchType type;
    @ManyToOne
    @JoinColumn(name="eventmodel_id")
    private EventModel event;

}
