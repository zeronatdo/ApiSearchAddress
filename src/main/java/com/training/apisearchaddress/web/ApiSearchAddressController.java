package com.training.apisearchaddress.web;

import com.training.apisearchaddress.model.SearchAddressService;
import com.training.apisearchaddress.model.adressresponse.AddressResponse;
import com.training.apisearchaddress.model.cityresponse.CityResponse;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.List;

/**
 * Class điều khiển xử lý các request của người dùng
 */
@RestController
@RequestMapping("/post_offices")
@Validated
@RequiredArgsConstructor
public class ApiSearchAddressController {
	
	private final SearchAddressService searchAddressService;
	
	
	/**
	 * Method tìm kiếm theo PostCode
	 *
	 * @param postCode postCode người dùng nhập vào
	 * @return danh sách địa chỉ cần tìm
	 */
	@RequestMapping(value = "/post/{postCode}", method = RequestMethod.GET)
	public ResponseEntity<?> searchByPostCode(
			@Pattern(regexp = "[\\d- ]*") @PathVariable("postCode") String postCode) throws NotFoundException {
		List<AddressResponse> addressResponseList = searchAddressService.searchByPostCode(postCode);
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("data", addressResponseList);
		return ResponseEntity.ok(hashMap);
	}
	
	/**
	 * Method tìm kiếm địa chỉ theo prefectureCode
	 *
	 * @param prefectureCode prefectureCode người dùng nhập vào
	 * @return danh sách địa chỉ cần tìm
	 */
	@RequestMapping(value = "/prefectures/{prefectureCode}", method = RequestMethod.GET)
	public ResponseEntity<?> searchByPrefectureCode(
			@Pattern(regexp = "[\\d- ]*") @PathVariable("prefectureCode") String prefectureCode)
			throws NotFoundException {
		List<CityResponse> cityResponseList = searchAddressService.searchByPrefectureCode(prefectureCode);
		HashMap<String, List<CityResponse>> hashMap = new HashMap<>();
		hashMap.put("data", cityResponseList);
		return ResponseEntity.ok(hashMap);
	}
}
