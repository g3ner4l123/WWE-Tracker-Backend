package pkaiser.wwetracker.singlematch;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SingleMatch implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String playerOne;
	private String playerTwo;
	private int week;
	private String league;
	private String winner;
	private String comment;
	
	public String getPlayerOne() {
		return playerOne;
	}
	public void setPlayerOne(String playerOne) {
		this.playerOne = playerOne;
	}
	public String getPlayerTwo() {
		return playerTwo;
	}
	public void setPlayerTwo(String playerTwo) {
		this.playerTwo = playerTwo;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "SingleMatch [id=" + id + ", playerOne=" + playerOne + ", playerTwo=" + playerTwo + ", week=" + week
				+ ", league=" + league + ", winner=" + winner + ", comment=" + comment + "]";
	}
	
	
}
