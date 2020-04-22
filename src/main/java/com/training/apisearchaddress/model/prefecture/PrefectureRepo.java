package com.training.apisearchaddress.model.prefecture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repo của bảng tbl_prefecture
 */
@Repository
public interface PrefectureRepo extends JpaRepository<Prefecture, Integer> {
	
	Prefecture findByPrefectureId(int prefectureId);
	
	Prefecture findByPrefectureCode(String prefectureCode);
}
