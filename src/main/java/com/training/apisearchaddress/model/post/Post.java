package com.training.apisearchaddress.model.post;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity của bảng tbl_post
 */
@Data
@Entity
@Table(name = "tbl_post")
public class Post implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int postId;
	
	@Column(name = "update_show")
	private int updateShow;
	
	@Column(name = "change_reason")
	private int changeReason;
	
	@Column(name = "multi_area")
	private int multiArea;
	
	@Column(name = "post_code")
	private String postCode;
}
