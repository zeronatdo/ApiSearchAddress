package com.training.apisearchaddress.model;

import com.training.apisearchaddress.model.adressresponse.AddressResponse;
import com.training.apisearchaddress.model.adressresponse.AddressResponseRepo;
import com.training.apisearchaddress.model.cityresponse.CityResponse;
import com.training.apisearchaddress.model.cityresponse.CityResponseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service xử lý các request truy vấn vào database
 */
@Service
@RequiredArgsConstructor
public class SearchAddressService {

	private final AddressResponseRepo addressResponseRepo;

	private final CityResponseRepo cityResponseRepo;
	
	
	/**
	 * Method tìm kiếm theo postCode
	 * 
	 * @param postCode mã bưu điện cần tìm kiếm
	 * @return danh sách địa chỉ gửi vè controller
	 */
	public List<AddressResponse> searchByPostCode(String postCode) {
		return addressResponseRepo.findAddressResponsesByPostCode(postCode);
	}
	
	/**
	 * Method tìm kiếm theo prefectureCode
	 * 
	 * @param prefectureCode mã tỉnh người dùng nhập vào
	 * @return danh sách thành phố gửi về controller
	 */
	public List<CityResponse> searchByPrefectureCode(String prefectureCode) {
		return cityResponseRepo.findCityResponseByPrefectureCode(prefectureCode);
	}
}
