package com.cg.application.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.application.bean.Day;

public interface SportsRepo extends JpaRepository<Day, Integer>{
	
	//Day save(Day day);
	
	@Query(value="SELECT d FROM Day d WHERE d.name=(:name)")
	Day findByDayName(@Param(value="name")String name);
	
	@Query(value="SELECT d FROM Day d inner join d.game g where g.name=(:name)")
	List<Day> findByGameName(@Param(value="name")String name);

}
