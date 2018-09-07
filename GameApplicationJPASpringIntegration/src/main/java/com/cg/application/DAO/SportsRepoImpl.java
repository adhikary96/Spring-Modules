package com.cg.application.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.application.bean.Day;
import com.cg.application.bean.Game;

public class SportsRepoImpl implements SportsRepo {
	
	protected EntityManager em;
	
	public SportsRepoImpl(EntityManager em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}
	
	public SportsRepoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Day save(Day day) {
		
		em.getTransaction().begin();
		em.merge(day);
		em.getTransaction().commit();
		
		return day;
	}

	@Override
	public Day findByDayName(String name) {
		
		String query = "SELECT d FROM Day d WHERE d.name=:n";
		
		TypedQuery<Day> queryList = em.createQuery(query, Day.class);
		queryList.setParameter("n", name);
		Day day = queryList.getSingleResult();
		return day;
	}

	@Override
	public List<Day> findByGameName(String name) {
		// TODO Auto-generated method stub
		
		String gameQuery = "SELECT g FROM Game g WHERE g.name=:gn";
		
		TypedQuery<Game> gameList = em.createQuery(gameQuery, Game.class);
		
		/*List<Day> dayList = new ArrayList<Day>();
		
		for (Day day : data.values()) {
			
			List<Game> list = day.getGame();
			for (Game game : list) {
				System.out.println(game);
				System.out.println();
				if(game.getName().equals(name)){
					dayList.add(day);
				}
			}
		}
		return dayList;*/
		return null;
	}

	
}
