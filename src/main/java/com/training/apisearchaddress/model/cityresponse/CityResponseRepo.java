package com.training.apisearchaddress.model.cityresponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repo của cityResponse
 */
@Repository
public interface CityResponseRepo extends JpaRepository<CityResponse, String> {
	
	@Query(value = "SELECT code, city, city_kana, prefecture, prefecture_kana, prefecture_code " +
			"FROM tbl_city c " +
			"INNER JOIN tbl_prefecture tp on c.prefecture_id = tp.prefecture_id " +
			"WHERE prefecture_code = :prefectureCode ", nativeQuery = true)
	List<CityResponse> findCityResponseByPrefectureCode(@Param("prefectureCode") String prefectureCode);
}
