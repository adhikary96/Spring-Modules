package com.cg.application.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.application.DAO.SportsRepo;
import com.cg.application.bean.Day;

@Service(value="service")
public class SportsServiceImpl implements SportsService{
	
	@Autowired
	private SportsRepo repo;
	
	@Override
	@Transactional
	public Day addDay(Day day) {
		// TODO Auto-generated method stub
		return repo.save(day);
	}

	@Override
	public Day findByDay(String name) {
		// TODO Auto-generated method stub
		return repo.findByDayName(name);
	}

	@Override
	public List<Day> findByGame(String name) {
		// TODO Auto-generated method stub
		return repo.findByGameName(name);
	}

	
	
}
