package com.ra2.jdbctemplate_h2.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ra2.jdbctemplate_h2.model.Customer;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setAge(rs.getInt("age"));
            customer.setCicle(rs.getString("cicle"));
            customer.setYear(rs.getInt("yearr"));
            return customer;
        }
    }

    public void createTableCustomers() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS customers");
        jdbcTemplate.execute(
            "CREATE TABLE customers (" +
            "age INT, " +
            "cicle VARCHAR(255), " +
            "yearr INT)"
        );
    }

    public void insertSampleData() {
        jdbcTemplate.update("INSERT INTO customers (age, cicle, yearr) VALUES (?, ?, ?)", 18, "First Cycle", 2023);
        jdbcTemplate.update("INSERT INTO customers (age, cicle, yearr) VALUES (?, ?, ?)", 20, "Second Cycle", 2024);
        jdbcTemplate.update("INSERT INTO customers (age, cicle, yearr) VALUES (?, ?, ?)", 22, "Final Cycle", 2025);
        }

        public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT age, cicle, yearr FROM customers", new CustomerRowMapper());
        }

        public int createCustomer(Customer customer) {
        return jdbcTemplate.update(
            "INSERT INTO customers (age, cicle, yearr) VALUES (?, ?, ?)",
            customer.getAge(),
            customer.getCicle(),
            customer.getYear()
        );
        }
    }
