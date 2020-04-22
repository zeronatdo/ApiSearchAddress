package com.training.apisearchaddress.model.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repo của bảng tbl_city
 */
@Repository
public interface CityRepo extends JpaRepository<City, Integer> {
	
	City findByCityId(int cityId);
	
	List<City> findByPrefectureId(int prefectureId);
}
