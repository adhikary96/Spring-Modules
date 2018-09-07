package com.cg.application.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cg.application.bean.Day;
import com.cg.application.bean.Game;

public class SportsRepoImpl implements SportsRepo {
	private Map<String, Day> data;
	
	public SportsRepoImpl(Map<String, Day> map) {
		// TODO Auto-generated constructor stub
		this.data = map;
	}
	
	public SportsRepoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Day save(Day day) {
		// TODO Auto-generated method stub
		data.put(day.getName(), day);
		return day;
	}

	@Override
	public Day findByDayName(String name) {
		// TODO Auto-generated method stub
		if (data.containsKey(name)) {
			return data.get(name);
		} else {
			return null;
		}
	}

	@Override
	public List<Day> findByGameName(String name) {
		// TODO Auto-generated method stub
		List<Day> dayList = new ArrayList<Day>();
		
		for (Day day : data.values()) {
			
			List<Game> list = day.getGame();
			for (Game game : list) {
				/*System.out.println(game);
				System.out.println();*/
				if(game.getName().equals(name)){
					dayList.add(day);
				}
			}
		}
		return dayList;
	}

	

	
	
	

}
