package pkaiser.wwetracker.specialmatch;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SpecialMatch implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String[] players;
	private String league;
	private String winner;
	private String comment;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String[] getPlayers() {
		return players;
	}
	public void setPlayers(String[] players) {
		this.players = players;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
