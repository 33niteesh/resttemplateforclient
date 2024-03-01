package com.RestTemplateApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.RestTemplateApplication.entity.Client;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class RestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
	}
}
	
	
//	@Autowired(required=true)
//	private RestTemplate restTemplate;

//	@Override
//	public void run(String... args) throws Exception {
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<Object> entity = new HttpEntity<Object>(headers);
//
//		String url = "http://localhost:8080/getDetails/api/v1/all_clients";
//		String url1client = "http://localhost:8080/getDetails/api/v1/client/33";
//		String postUrl = "http://localhost:8080/getDetails/api/v1/add_client";
//		String putUrl = "http://localhost:8080/getDetails/api/v1/client_edit";
//		String deleteUrl = "http://localhost:8080/getDetails/api/v1/client_remove/220";
//		
//		try {
//		ResponseEntity<String> out = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//		System.out.println("         <- all clients ->      " + out.getBody());
//		System.out.println("status code,message -> " + out.getStatusCode());
//		System.out.println();
//		}catch(Exception e) {
//			String singleclient = e.getMessage();
//			System.out.println("          <- all clients ->         ");
//			System.out.println(singleclient);
//			System.out.println();
//		}
//		
//		try {
//			ResponseEntity<String> singleclient = restTemplate.exchange(url1client, HttpMethod.GET, entity, String.class);
//			System.out.println("          <- Client ->         " + singleclient.getBody());
//			System.out.println("status code,message -> " + singleclient.getStatusCode());
//			System.out.println();
//		}catch(Exception e) {
//			String singleclient = e.getMessage();
//			System.out.println("          <- Error getting Client ->         ");
//			System.out.println(singleclient);
//			System.out.println();
//		}
//		
//		try {
//		HttpHeaders headerspost = new HttpHeaders();
//		headerspost.setContentType(MediaType.APPLICATION_JSON);
//		Client addclient = new Client(220, "hello", "john", "123@example");
//		String json = new ObjectMapper().writeValueAsString(addclient);
//		HttpEntity<Object> entitypost = new HttpEntity<Object>(json, headerspost);
//		ResponseEntity<String> newclient = restTemplate.exchange(postUrl, HttpMethod.POST, entitypost, String.class);
//		System.out.println("          <- Added Client ->         ");
//		System.out.println("status code,message -> " + newclient.getStatusCode());
//		System.out.println();
//		}catch(Exception e) {
//			String singleclient = e.getMessage();
//			System.out.println("          <- Error adding Client ->         ");
//			System.out.println(singleclient);
//			System.out.println();
//		}
//		
//		
//		try {
//		HttpHeaders headersupdate = new HttpHeaders();
//		headersupdate.setContentType(MediaType.APPLICATION_JSON);
//		Client put = new Client(220, "hello", "johnseena", "123@example");
//		String json1 = new ObjectMapper().writeValueAsString(put);
//		HttpEntity<Object> entityput = new HttpEntity<Object>(json1, headersupdate);
//		ResponseEntity<String> client = restTemplate.exchange(putUrl, HttpMethod.PUT, entityput, String.class);
//		System.out.println("          <- Updated Client ->         ");
//		System.out.println("status code,message -> " + client.getStatusCode());
//		System.out.println();
//		}catch(Exception e) {
//			String singleclient = e.getMessage();
//			System.out.println("          <- Cannot update Client ->         ");
//			System.out.println(singleclient);
//			System.out.println();
//		}
//		
//		
//		try {
//		ResponseEntity<String> responseMS  = restTemplate.exchange(deleteUrl, HttpMethod.DELETE,entity , String.class);
//		System.out.println("          <- Deleted Client ->         ");
//		System.out.println("status message -> " + responseMS.getBody());
//		}catch(Exception e) {
//			String singleclient = e.getMessage();
//			System.out.println("          <- Cannot Delete Client ->         ");
//			System.out.println(singleclient);
//			System.out.println();
//		}
//		
//	}


