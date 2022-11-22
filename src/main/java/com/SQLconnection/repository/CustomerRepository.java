package com.SQLconnection.repository;

import java.util.List;

import com.SQLconnection.model.Customer;

public interface CustomerRepository {
	int save(Customer c);

	int update(int id, Customer c);

	Customer findById(int id);

	List<Customer> findByName(String Name);

	List<Customer> findByCountry(String Country);

	List<Customer> findAll();

	int deleteById(int id);

	int deleteAll();
}
