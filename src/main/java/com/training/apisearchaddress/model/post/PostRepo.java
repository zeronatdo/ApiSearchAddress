package com.training.apisearchaddress.model.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repo của bảng tbl_post
 */
@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
	
	Post findByPostCode(String postCode);
}
