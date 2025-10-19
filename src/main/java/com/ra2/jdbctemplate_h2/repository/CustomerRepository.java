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

    private static final class CustomerRowMapper implements RowMapper <Customer>{
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{

            Customer customer = new Customer();
            customer.setId(rs.getLong("id"));
            customer.setFirstName(rs.getString("f_name"));
            customer.setLastName(rs.getString("l_name"));

            return customer;
        }

    }

    public void createTableCustomers(){
        jdbcTemplate.execute("DROP TABLE customers if EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers (id SERIAL, f_name VARCHAR(255), l:name VARCHAR (255))");
    }

    public void insertSampleData(){
        jdbcTemplate.update("INSERT INTO customers (f_name, l_name) VALUES (?,?)", "Jhon", "Doe");
        jdbcTemplate.update("INSERT INTO customers (f_name, l_name) VALUES (?,?)", "Jane", "Smith");
         jdbcTemplate.update("INSERT INTO customers (f_name, l_name) VALUES (?,?)", "Bob", "Johnson");
}

public List <Customer> findAll(){
    return jdbcTemplate.query("SELECT id, f_name l_name FROM customers", new  CustomerRowMapper());
}
}