package com.RestTemplateApplication.controller;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.RestTemplateApplication.entity.Client;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v2")
@Tag(name="Rest template Api")
public class Controller {
	
	@GetMapping("/clients")
    @Operation(summary="get all clients")
    public ResponseEntity<?> getAllContacts() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<Object>(headers);
		String url = "http://localhost:8080/getDetails/api/v1/all_clients";
		try {
			ResponseEntity<Client> out = restTemplate.exchange(url, HttpMethod.GET, entity, Client.class);
			JSONObject r=new JSONObject();
			r.put("data",out.getBody());
			r.put("status code", out.getStatusCode());
			return new ResponseEntity<>(r,HttpStatus.OK);
			}catch(Exception e) {
				JSONObject r=new JSONObject();
				String singleclient = e.getMessage();
				r.put("data",singleclient);
				r.put("status code", HttpStatus.INTERNAL_SERVER_ERROR);
				return new ResponseEntity<>(r.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
    }
	
	@GetMapping("/client/{id}")
    @Operation(summary="get Client by Id")
    public ResponseEntity<?> getUser(@PathVariable int id){
		String url1client = "http://localhost:8080/getDetails/api/v1/client/"+id;
    	RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<Object>(headers);
    	try {
			ResponseEntity<Client> singleclient = restTemplate.exchange(url1client, HttpMethod.GET, entity, Client.class);
			JSONObject r=new JSONObject();
    		r.put("Status", singleclient.getStatusCode());
    		r.put("Status code", singleclient.getStatusCode());
    		r.put("message", "Success");
    		r.put("data", singleclient.getBody());
    		return new ResponseEntity<>(r.toString(),HttpStatus.OK);
		}catch(Exception e) {
			JSONObject r=new JSONObject();
			String singleclient = e.getMessage();
			r.put("data",singleclient);
			r.put("status code", HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(r.toString(),HttpStatus.NOT_FOUND);
		}
    }
	
	@PostMapping("/add_client")
    @Operation(summary="Add Client")
    public ResponseEntity<?> addUser(@RequestBody Client user){
    	try {
    		RestTemplate restTemplate = new RestTemplate();
    		HttpHeaders headerspost = new HttpHeaders();
    		headerspost.setContentType(MediaType.APPLICATION_JSON);
    		String json = new ObjectMapper().writeValueAsString(user);
    		String postUrl = "http://localhost:8080/getDetails/api/v1/add_client";
    		HttpEntity<Object> entitypost = new HttpEntity<Object>(json, headerspost);
    		ResponseEntity<String> newclient = restTemplate.exchange(postUrl, HttpMethod.POST, entitypost, String.class);
    		return new ResponseEntity<>("Client added",HttpStatus.CREATED);
    	}
    	catch(Exception e) {
    		JSONObject r=new JSONObject();
			String singleclient = e.getMessage();
			r.put("data",singleclient);
			r.put("status code", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<>(r.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}

    }

	 @PutMapping("/client_edit")
	 @Operation(summary="Edit Client details")
	  public ResponseEntity<?> updateUser(@RequestBody Client user){
	    	try {
	    		String putUrl = "http://localhost:8080/getDetails/api/v1/client_edit";
	    		RestTemplate restTemplate = new RestTemplate();
	    		HttpHeaders headersupdate = new HttpHeaders();
	    		headersupdate.setContentType(MediaType.APPLICATION_JSON);
	    		String json1 = new ObjectMapper().writeValueAsString(user);
	    		HttpEntity<Object> entityput = new HttpEntity<Object>(json1, headersupdate);
	    		ResponseEntity<String> client = restTemplate.exchange(putUrl, HttpMethod.PUT, entityput, String.class);
	    		return new ResponseEntity<>("Client details updated",HttpStatus.ACCEPTED);
	    	}catch(Exception e) {
	    		JSONObject r=new JSONObject();
				String singleclient = e.getMessage();
				r.put("data",singleclient);
				r.put("status code", HttpStatus.NOT_FOUND);
				return new ResponseEntity<>(r.toString(),HttpStatus.NOT_FOUND);
	    	}
	    }
	 
	 @DeleteMapping("/client_remove/{id}")
	  @Operation(summary="Delete Client by Id")
	    public ResponseEntity<?> deleteUser(@PathVariable int id){
	    	try {
	    		String deleteUrl = "http://localhost:8080/getDetails/api/v1/client_remove/"+id;
	    		RestTemplate restTemplate = new RestTemplate();
	    		HttpHeaders headers = new HttpHeaders();
	    		headers.setContentType(MediaType.APPLICATION_JSON);
	    		HttpEntity<Object> entity = new HttpEntity<Object>(headers);
	    		ResponseEntity<String> responseMS  = restTemplate.exchange(deleteUrl, HttpMethod.DELETE,entity , String.class);
	    		return new ResponseEntity<>("client deleted with id : ",HttpStatus.OK);
	    	}
	    	catch (Exception e){
	    		JSONObject r=new JSONObject();
				String singleclient = e.getMessage();
				r.put("data",singleclient);
				r.put("status code", HttpStatus.NOT_FOUND);
				return new ResponseEntity<>(r.toString(),HttpStatus.NOT_FOUND);
		}
	    }
}
