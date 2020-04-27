package com.training.apisearchaddress.model;

import com.training.apisearchaddress.model.adressresponse.AddressResponse;
import com.training.apisearchaddress.model.adressresponse.AddressResponseRepo;
import com.training.apisearchaddress.model.cityresponse.CityResponse;
import com.training.apisearchaddress.model.cityresponse.CityResponseRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SearchAddressServiceTest {
    private MockMvc mockMvc;

    @InjectMocks
    private SearchAddressService searchAddressService;

    @Mock
    private AddressResponseRepo addressResponseRepo;

    @Mock
    private CityResponseRepo cityResponseRepo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(searchAddressService).build();
    }

    @Test
    public void testSeachByPostCode() {
        AddressResponse addressResponse1 = new AddressResponse("1", "hanoi", "hanoikana", "hanoiT", "hanoiTkana",
                "1", "CauGiay", "CauGiayKana", 0, 0, 0, "1", "1", 0, 0, 0);
        AddressResponse addressResponse2 = new AddressResponse("2", "hanoi", "hanoikana", "hanoiT", "hanoiTkana",
                "2", "CauGiay", "CauGiayKana", 0, 0, 0, "2", "2", 0, 0, 0);
        List<AddressResponse> addressResponseList = addressResponseRepo.findAddressResponsesByPostCode("1");
        when(addressResponseRepo.findAddressResponsesByPostCode("1"))
                .thenReturn(Arrays.asList(addressResponse1, addressResponse2));
        verify(addressResponseRepo, times(1)).findAddressResponsesByPostCode("1");
        verifyNoMoreInteractions(addressResponseRepo);
    }

    @Test
    public void testSearchByPrefectureCode() {
        CityResponse cityResponse1 = new CityResponse("1", "hanoi", "hanoikana", "hanoit", "hanoiTkana", "1");
        CityResponse cityResponse2 = new CityResponse("2", "hanoi", "hanoikana", "hanoit", "hanoiTkana", "2");
        List<CityResponse> cityResponseList = cityResponseRepo.findCityResponseByPrefectureCode("1");
        when(cityResponseRepo.findCityResponseByPrefectureCode("1")).thenReturn(Arrays.asList(cityResponse1, cityResponse2));
        verify(cityResponseRepo, times(1)).findCityResponseByPrefectureCode("1");
        verifyNoMoreInteractions(cityResponseRepo);
    }
}
