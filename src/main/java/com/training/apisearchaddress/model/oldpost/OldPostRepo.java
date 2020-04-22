package com.training.apisearchaddress.model.oldpost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repo của bảng tbl_old_post
 */
@Repository
public interface OldPostRepo extends JpaRepository<OldPost, Integer> {
	
	OldPost findByOldPostId(int oldPostId);
}
