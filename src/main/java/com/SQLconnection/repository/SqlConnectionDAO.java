package com.SQLconnection.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.SQLconnection.model.Customer;

@Repository
public class SqlConnectionDAO implements CustomerRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	static final String SQL = "select * from Customer";

	public List<Customer> Read() {

		List<Customer> customers = new ArrayList<Customer>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

		for (Map<String, Object> row : rows) {
			Customer customer = new Customer();

			customer.setCustNo((int) row.get("Cust_id"));
			customer.setCustName((String) row.get("Cust_name"));
			customer.setCountry((String) row.get("Country"));

			customers.add(customer);
		}
		return customers;
	}

	@Override
	public List<Customer> findAll() {
		return jdbcTemplate.query("SELECT * from Customer", BeanPropertyRowMapper.newInstance(Customer.class));
	}

	@Override
	public int save(Customer c) {
		return jdbcTemplate.update("INSERT INTO Customer (Cust_id,Cust_name,Country) VALUES(?,?,?)",
				new Object[] { c.getCustNo(), c.getCustName(), c.getCountry() });
	}

	
	
	
	
	@Override
	public int update(Customer c) {
		return jdbcTemplate.update("UPDATE Customer SET Cust_name=?, Country=?,  WHERE Cust_id=?",
				new Object[] { c.getCustNo(), c.getCustName(), c.getCountry() });
	}

	@Override
	public Customer findById(int id) {
		try {
			Customer c = jdbcTemplate.queryForObject("select * from Customer WHERE Cust_id=?",
					BeanPropertyRowMapper.newInstance(Customer.class), id);

			return c;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM Customer WHERE Cust_id=?", id);
	}

	
	@Override
	public List<Customer> findByName(boolean Name) {
		return jdbcTemplate.query("SELECT * from Customer WHERE Cust_name=?",
				BeanPropertyRowMapper.newInstance(Customer.class), Name);
	}

	@Override
	public List<Customer> findByCountry(String Country) {
		String q = "SELECT * from Customer WHERE title LIKE '%" + Country + "%'";
		return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Customer.class));
	}

	@Override
	public int deleteAll() {
		return jdbcTemplate.update("DELETE from Customer");
	}

}
