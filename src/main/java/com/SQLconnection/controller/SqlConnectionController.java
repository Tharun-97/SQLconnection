package com.SQLconnection.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

		List<Customer> customers = dao.Read();

		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping(value = "view")
	public ResponseEntity<?> findAll() {

		List<Customer> customers = dao.findAll();

		return new ResponseEntity<>(customers, HttpStatus.OK);

	}

	@GetMapping(value = "insert")
	public ResponseEntity<?> insert(@RequestParam Map<String, String> insert) {

		Customer c = new Customer(Integer.parseInt(insert.get("id")), insert.get("name"), insert.get("country"));

		dao.save(c);

		return new ResponseEntity<>("The Details inserted succesfully", HttpStatus.OK);

	}

	@GetMapping(value = "delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {

		dao.deleteById(id);

		return new ResponseEntity<>("The Details deleted successfully", HttpStatus.OK);
	}

	@GetMapping(value = "deleteAll")
	public ResponseEntity<?> deleteAll() {

		dao.deleteAll();

		return new ResponseEntity<>("The All details deleted successfully", HttpStatus.OK);

	}

	@GetMapping(value = "update/{id}/{name}/{country}")
	public ResponseEntity<?> update(@PathVariable("id") int Cust_id, @PathVariable("name") String Cust_name,
			@PathVariable("country") String Country) {

		dao.update(Cust_id, Cust_name, Country);

		return null;

	}

}
