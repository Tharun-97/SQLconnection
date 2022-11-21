package com.SQLconnection.repository;

import java.util.List;

import com.SQLconnection.model.Customer;

public interface CustomerRepository {
	int save(Customer c);

	int update(int Cust_id,String Cust_name,String Country);

	Customer findById(int id);

	int deleteById(int id);

	List<Customer> findAll();

	List<Customer> findByName(boolean Name);

	List<Customer> findByCountry(String Country);

	int deleteAll();
}
