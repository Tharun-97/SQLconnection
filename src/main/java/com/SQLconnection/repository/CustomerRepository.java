package com.SQLconnection.repository;

import java.util.List;

import com.SQLconnection.model.Customer;

public interface CustomerRepository {
	int save(Customer c);

	int update(Customer c);

	Customer findById(int id);

	int deleteById(int id);

	List<Customer> findAll();

	List<Customer> findByName(boolean Name);

	List<Customer> findByCountry(String Country);

	int deleteAll();
}
