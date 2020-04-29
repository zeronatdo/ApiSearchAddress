package com.training.apisearchaddress.web;

import com.training.apisearchaddress.model.SearchAddressService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ApiSearchAddressControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	ApiSearchAddressController apiSearchAddressController;
	
	@Mock
	SearchAddressService searchAddressService;
	
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(apiSearchAddressController).build();
	}

	@Test
	public void testSearchByPostCode() throws Exception {
		String postCode = "1";
		when(searchAddressService.searchByPostCode(any())).thenReturn(Collections.emptyList());
		mockMvc.perform(get("/post_offices/post/{postCode}", postCode))
			.andExpect(status().isOk());
		verify(searchAddressService, times(1)).searchByPostCode(postCode);
		verifyNoMoreInteractions(searchAddressService);
	}
	
	@Test
	public void testSearchByPrefectureCode() throws Exception {
		String prefectureCode = "1";
		when(searchAddressService.searchByPrefectureCode(any())).thenReturn(Collections.emptyList());
		mockMvc.perform(get("/post_offices/prefectures/{prefectureCode}", prefectureCode));
		verify(searchAddressService, times(1)).searchByPrefectureCode(prefectureCode);
		verifyNoMoreInteractions(searchAddressService);
	}
}
