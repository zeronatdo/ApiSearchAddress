package com.training.apisearchaddress.model.city;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity của bảng tbl_city
 */
@Data
@Entity
@Table(name = "tbl_city")
public class City implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "prefecture_id")
	private int prefectureId;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "city_kana")
	private String cityKana;
}
