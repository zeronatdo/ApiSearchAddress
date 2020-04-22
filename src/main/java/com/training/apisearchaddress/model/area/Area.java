package com.training.apisearchaddress.model.area;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity của bảng tbl_area
 */
@Data
@Entity
@Table(name = "tbl_area")
public class Area implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_id")
	private int areaId;
	
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "chome_area")
	private int chomeArea;
	
	@Column(name = "koaza_area")
	private int koazaArea;
	
	@Column(name = "multi_post_area")
	private int multiPostArea;
	
	@Column(name = "post_id")
	private int postId;
	
	@Column(name = "old_post_id")
	private int oldPostId;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "area_kana")
	private String areaKana;
}
