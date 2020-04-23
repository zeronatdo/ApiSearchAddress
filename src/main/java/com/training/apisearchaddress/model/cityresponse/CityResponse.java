package com.training.apisearchaddress.model.cityresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity của thông tin của thành phố tìm kiếm theo prefectureCode
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CityResponse {
	
	@Column(name = "code")
	@Id
	@JsonProperty("code")
	private String code;
	
	@Column(name = "city")
	@JsonProperty("city")
	private String city;
	
	@Column(name = "city_kana")
	@JsonProperty("city_kana")
	private String cityKana;
	
	@Column(name = "prefecture")
	@JsonProperty("prefecture")
	private String prefecture;
	
	@Column(name = "prefecture_kana")
	@JsonProperty("prefecture_kana")
	private String prefectureKana;
	
	@Column(name = "prefecture_code")
	@JsonProperty("prefecture_code")
	private String prefectureCode;
}
