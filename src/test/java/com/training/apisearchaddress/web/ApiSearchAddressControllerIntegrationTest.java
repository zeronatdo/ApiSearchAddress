package com.training.apisearchaddress.web;

import com.training.apisearchaddress.ApiSearchAddressApplication;
import com.training.apisearchaddress.model.SearchAddressService;
import com.training.apisearchaddress.model.adressresponse.AddressResponse;
import com.training.apisearchaddress.model.cityresponse.CityResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiSearchAddressApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiSearchAddressControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @MockBean
    private SearchAddressService searchAddressService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testSearchByPostCode() throws Exception {
    }

    @Test
    public void testSearchByPrefectureCode() throws Exception {

    }
}
