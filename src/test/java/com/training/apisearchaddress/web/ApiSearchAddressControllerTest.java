package com.training.apisearchaddress.web;

import com.training.apisearchaddress.model.SearchAddressService;
import com.training.apisearchaddress.model.adressresponse.AddressResponse;
import com.training.apisearchaddress.model.cityresponse.CityResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ApiSearchAddressControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private ApiSearchAddressController apiSearchAddressController;
	
	@Mock
	private SearchAddressService searchAddressService;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(apiSearchAddressController).build();
	}
	
	@Test
	public void testSearchByPostCode() throws Exception {
		AddressResponse addressResponse1 = new AddressResponse("1", "hanoi", "hanoikana", "hanoiT", "hanoiTkana",
				"1", "CauGiay", "CauGiayKana", 0, 0, 0, "1", "1", 0, 0, 0);
		AddressResponse addressResponse2 = new AddressResponse("2", "hanoi", "hanoikana", "hanoiT", "hanoiTkana",
				"2", "CauGiay", "CauGiayKana", 0, 0, 0, "2", "2", 0, 0, 0);
		when(searchAddressService.searchByPostCode("1"))
			.thenReturn(Arrays.asList(addressResponse1, addressResponse2));
		mockMvc.perform(get("/post_offices/post/{postCode}", "1"))
			.andExpect(status().isOk());
		verify(searchAddressService, times(1)).searchByPostCode("1");
		verifyNoMoreInteractions(searchAddressService);
	}
	
	@Test
	public void testSearchByPrefectureCode() throws Exception {
		CityResponse cityResponse1 = new CityResponse("1", "hanoi", "hanoikana", "hanoit", "hanoiTkana", "1");
		CityResponse cityResponse2 = new CityResponse("2", "hanoi", "hanoikana", "hanoit", "hanoiTkana", "2");
		when(searchAddressService.searchByPrefectureCode("1")).thenReturn(Arrays.asList(cityResponse1, cityResponse2));
		mockMvc.perform(get("/post_offices/prefectures/{prefectureCode}", "1"));
		verify(searchAddressService, times(1)).searchByPrefectureCode("1");
		verifyNoMoreInteractions(searchAddressService);
	}
}
