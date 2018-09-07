package com.cg.application.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.application.bean.Day;
import com.cg.application.bean.Game;


@Repository
public class SportsRepoImpl implements SportsRepo {
	
	@PersistenceContext
	protected EntityManager em;

	public SportsRepoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public Day save(Day day) {
		em.merge(day);		
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

		String gameQuery = "SELECT d FROM Day d inner join d.game g where g.name=:name";

		TypedQuery<Day> gameList = em.createQuery(gameQuery, Day.class);
		gameList.setParameter("name", name);
		
		return gameList.getResultList();
	}

}
