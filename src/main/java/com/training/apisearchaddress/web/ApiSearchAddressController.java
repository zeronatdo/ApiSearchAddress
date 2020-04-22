package com.training.apisearchaddress.web;

import com.training.apisearchaddress.model.errormessage.ErrorMessage;
import com.training.apisearchaddress.model.SearchAddressService;
import com.training.apisearchaddress.model.adressresponse.AddressResponse;
import com.training.apisearchaddress.model.cityresponse.CityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Class điều khiển xử lý các request của người dùng
 */
@RestController
@RequestMapping("post_offices")
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
	public ResponseEntity<Object> searchByPostCode(@PathVariable("postCode") String postCode) {
		//Loại bỏ space và dấu gạch ngang
		postCode = postCode.replace(" ", "").replace("-", "");
		
		//Kiểm tra postCode có đúng định dạng hay không. Nếu đúng thì thực hiện tìm kiếm. Nếu sai thì in ra thông báo lỗi
		if (!postCode.matches("\\d*")) {
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setError(400);
			errorMessage.setError_description(
					"Thiếu thông số bắt buộc, giá trị không hợp lệ hoặc request không đúng định dạng.");
			return ResponseEntity.badRequest().body(errorMessage);
		}
		List<AddressResponse> addressResponseList = searchAddressService.searchByPostCode(postCode);
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
	public ResponseEntity<Object> searchByPrefectureCode(@PathVariable("prefectureCode") String prefectureCode) {
		//Loại bỏ space và dấu gạch ngang
		prefectureCode = prefectureCode.replace(" ", "").replace("-", "");
		
		//Kiểm tra prefectureCode có đúng định dạng hay không. Nếu đúng thì thực hiện tìm kiếm. Nếu sai thì báo lỗi
		if (!prefectureCode.matches("\\d*")) {
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setError(400);
			errorMessage.setError_description(
					"Thiếu thông số bắt buộc, giá trị không hợp lệ hoặc request không đúng định dạng.");
			return ResponseEntity.badRequest().body(errorMessage);
		}
		List<CityResponse> cityResponseList = searchAddressService.searchByPrefectureCode(prefectureCode);
		HashMap<String, List<CityResponse>> hashMap = new HashMap<>();
		hashMap.put("data", cityResponseList);
		return new ResponseEntity<>(hashMap, HttpStatus.OK);
	}
}
