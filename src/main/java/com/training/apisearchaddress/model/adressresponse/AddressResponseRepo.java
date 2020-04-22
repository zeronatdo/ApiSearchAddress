package com.training.apisearchaddress.model.adressresponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repo của AddressResponse
 */
@Repository
public interface AddressResponseRepo extends JpaRepository<AddressResponse, String> {
	
	@Query(value = "SELECT code," +
			"       city," +
			"       city_kana," +
			"       prefecture," +
			"       prefecture_kana," +
			"       prefecture_code," +
			"       area," +
			"       area_kana," +
			"       multi_post_area," +
			"       koaza_area," +
			"       chome_area," +
			"       old_post_code," +
			"       post_code," +
			"       multi_area," +
			"       update_show," +
			"       change_reason " +
			"FROM tbl_area a " +
			"         INNER JOIN tbl_post tp ON a.post_id = tp.post_id " +
			"         INNER JOIN tbl_city tc ON a.city_id = tc.city_id " +
			"         INNER JOIN tbl_old_post top ON a.old_post_id = top.old_post_id " +
			"         INNER JOIN tbl_prefecture t ON tc.prefecture_id = t.prefecture_id " +
			"WHERE tp.post_code = :postCode ", nativeQuery = true)
	List<AddressResponse> findAddressResponsesByPostCode(@Param("postCode") String postCode);
}
