package com.training.apisearchaddress.model.area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repo của tbl_area
 */
@Repository
public interface AreaRepo extends JpaRepository<Area, Integer> {
	
	List<Area> findByPostId(int postId);
}
