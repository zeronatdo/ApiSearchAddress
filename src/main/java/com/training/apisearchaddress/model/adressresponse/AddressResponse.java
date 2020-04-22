package com.training.apisearchaddress.model.adressresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Entity của địa chỉ người dùng tìm kiếm theo postCode
 */
@Data
@Entity
public class AddressResponse {
	
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
	
	@Column(name = "prefectureCode")
	@JsonProperty("prefectureCode")
	private String prefectureCode;
	
	@Column(name = "area")
	@JsonProperty("area")
	private String area;
	
	@Column(name = "areaKana")
	@JsonProperty("areaKana")
	private String areaKana;
	
	@Column(name = "multi_post_area")
	@JsonProperty("multi_post_area")
	private int multiPostArea;
	
	@Column(name = "koaza_area")
	@JsonProperty("koaza_area")
	private int koazaArea;
	
	@Column(name = "chome_area")
	@JsonProperty("chome_area")
	private int chomeArea;
	
	@Column(name = "old_post_code")
	@JsonProperty("old_post_code")
	private String oldPostCode;
	
	@Column(name = "post_code")
	@JsonProperty("post_code")
	private String postCode;
	
	@Column(name = "multi_area")
	@JsonProperty("multi_area")
	private String multiArea;
	
	@Column(name = "update_show")
	@JsonProperty("update_show")
	private int updateShow;
	
	@Column(name = "change_reason")
	@JsonProperty("change_reason")
	private int changeReason;
}
