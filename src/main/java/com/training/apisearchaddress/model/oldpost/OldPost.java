package com.training.apisearchaddress.model.oldpost;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity của bảng tbl_old_post
 */
@Data
@Entity
@Table(name = "tbl_old_post")
public class OldPost implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "old_post_id")
	private int oldPostId;
	
	@Column(name = "old_post_code")
	private String oldPostCode;
}
