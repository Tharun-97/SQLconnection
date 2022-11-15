package com.SQLconnection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SQLconnection.model.Customer;
import com.SQLconnection.repository.SqlConnectionDAO;


@RestController
@RequestMapping("/api/")
public class SqlConnectionController {

	@Autowired
	SqlConnectionDAO dao;

	@GetMapping(value = "testAPI1")
	public ResponseEntity<?> customerInformation() {

		List<Customer> customers = dao.isData();
		
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
}
