package com.training.apisearchaddress.model.prefecture;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity của bảng tbl_prefecture
 */
@Data
@Entity
@Table(name = "tbl_prefecture")
public class Prefecture implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prefecture_id")
	private int prefectureId;
	
	@Column(name = "prefecture")
	private String prefecture;
	
	@Column(name = "prefecture_kana")
	private String prefectureKana;
	
	@Column(name = "prefecture_code")
	private String prefectureCode;
}
