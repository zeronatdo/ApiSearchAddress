package com.training.apisearchaddress.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.jsonassert.JsonAssert.with;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ApiSearchAddressControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	
	private HttpHeaders createHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return httpHeaders;
	}
	
	@Test
    public void testSearchByPostCode() throws Exception {
        HttpHeaders httpHeaders = createHttpHeaders();
        String postCode = "0010000";
        ResponseEntity<String> responseEntity = testRestTemplate.exchange("/post_offices/post/{postCode}",
				HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class, postCode);

		assertThat(responseEntity.getStatusCode().equals(HttpStatus.OK));
		with(responseEntity.getBody()).assertThat("$.data", hasSize(1));
    }

	@Test
	public void testSearchByPostCode_error400() {
		HttpHeaders httpHeaders = createHttpHeaders();
		String postCode = "abc";
		ResponseEntity<String> responseEntity = testRestTemplate.exchange("/post_offices/post/{postCode}",
				HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class, postCode);

		assertThat(responseEntity.getStatusCode().equals(HttpStatus.BAD_REQUEST));
		with(responseEntity.getBody())
				.assertThat("$.error", is(400))
				.assertThat("$.error_description", is("Thiếu thông số bắt buộc, giá trị không hợp lệ hoặc request không đúng định dạng."));
	}

	@Test
	public void testSearchByPostCode_error404() {
		HttpHeaders httpHeaders = createHttpHeaders();
		String postCode = "1001";
		ResponseEntity<String> responseEntity = testRestTemplate.exchange("/post_offices/post/{postCode}",
				HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class, postCode);

		assertThat(responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND));
		with(responseEntity.getBody())
				.assertThat("$.error", is(404))
				.assertThat("$.error_description", is("Cố gắng thao tác một tài nguyên không tồn tại."));
	}
	
	@Test
	public void testSearchByPrefectureCode() throws Exception {
		HttpHeaders httpHeaders = new HttpHeaders();
		String prefectureCode = "01";
		ResponseEntity<String> responseEntity = testRestTemplate.exchange("/post_offices/prefectures/{prefectureCode}",
				HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class, prefectureCode);
		assertThat(responseEntity.getStatusCode().equals(HttpStatus.OK));
		with(responseEntity.getBody()).assertThat("$.data", hasSize(1));
	}

	@Test
	public void testSearchByPrefectureCode_error400() {
		HttpHeaders httpHeaders = createHttpHeaders();
		String postCode = "abc";
		ResponseEntity<String> responseEntity = testRestTemplate.exchange("/post_offices/post/{postCode}",
				HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class, postCode);

		assertThat(responseEntity.getStatusCode().equals(HttpStatus.BAD_REQUEST));
		with(responseEntity.getBody())
				.assertThat("$.error", is(400))
				.assertThat("$.error_description", is("Thiếu thông số bắt buộc, giá trị không hợp lệ hoặc request không đúng định dạng."));
	}

	@Test
	public void testSearchByPrefectureCode_error404() {
		HttpHeaders httpHeaders = createHttpHeaders();
		String postCode = "1001";
		ResponseEntity<String> responseEntity = testRestTemplate.exchange("/post_offices/post/{postCode}",
				HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class, postCode);

		assertThat(responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND));
		with(responseEntity.getBody())
				.assertThat("$.error", is(404))
				.assertThat("$.error_description", is("Cố gắng thao tác một tài nguyên không tồn tại."));
	}
}
