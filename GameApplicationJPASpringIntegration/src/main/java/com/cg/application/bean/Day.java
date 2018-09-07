package com.cg.application.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Day {
	
	@Id
	@GeneratedValue
	private int dayId;
	
	private String name;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Game> game;
		
	public int getDayId() {
		return dayId;
	}
	public void setDayId(int dayId) {
		this.dayId = dayId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Game> getGame() {
		return game;
	}
	public void setGame(List<Game> game) {
		this.game = game;
	}
	@Override
	public String toString() {
		return "Day [dayId=" + dayId + ", name=" + name + ", game=" + game + "]";
	}
	
	
	

}
