package com.training.apisearchaddress.web;

import com.training.apisearchaddress.model.SearchAddressService;
import com.training.apisearchaddress.model.adressresponse.AddressResponse;
import com.training.apisearchaddress.model.cityresponse.CityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.List;

/**
 * Class điều khiển xử lý các request của người dùng
 */
@RestController
@RequestMapping("post_offices")
@Validated
public class ApiSearchAddressController {
	
	@Autowired
	SearchAddressService searchAddressService;
	
	
	/**
	 * Method tìm kiếm theo PostCode
	 *
	 * @param postCode postCode người dùng nhập vào
	 * @return danh sách địa chỉ cần tìm
	 */
	@RequestMapping(value = "/post/{postCode}", method = RequestMethod.GET)
	public ResponseEntity<Object> searchByPostCode(
			@Pattern(regexp = "[\\d- ]*") @NotNull @PathVariable("postCode") String postCode) {
		postCode = postCode.replace("-", "").replace(" ", "");
		List<AddressResponse> addressResponseList = searchAddressService.searchByPostCode(postCode);
		//Xử lý khi không có kết quả trả về
		if (addressResponseList.isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("data", addressResponseList);
		return new ResponseEntity<>(hashMap, HttpStatus.OK);
	}
	
	/**
	 * Method tìm kiếm địa chỉ theo prefectureCode
	 *
	 * @param prefectureCode prefectureCode người dùng nhập vào
	 * @return danh sách địa chỉ cần tìm
	 */
	@RequestMapping(value = "/prefectures/{prefectureCode}", method = RequestMethod.GET)
	public ResponseEntity<Object> searchByPrefectureCode(
			@Pattern(regexp = "[\\d- ]*") @NotNull @PathVariable("prefectureCode") String prefectureCode) {
		prefectureCode = prefectureCode.replace("-", "").replace(" ", "");
		List<CityResponse> cityResponseList = searchAddressService.searchByPrefectureCode(prefectureCode);
		//Xử lý khí không có kết quả trả về
		if (cityResponseList.isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		HashMap<String, List<CityResponse>> hashMap = new HashMap<>();
		hashMap.put("data", cityResponseList);
		return new ResponseEntity<>(hashMap, HttpStatus.OK);
	}
}
