package com.IBm._jdbc_annotation.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component(value="eDao")
public class EmployeeDAO {
	
	@Autowired
	 JtemplateClass jdbcTemplate;
	
	
	public JtemplateClass getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	
	public void setJdbcTemplate(JtemplateClass jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void createEmployee(Employee employee) {
		String query = "insert into employee(name) values(?)";
		Object obj[] = { employee.getName() };
		System.out.println(jdbcTemplate.toString());
		jdbcTemplate.update(query, obj);
		System.out.println("done");
	}
	
	public void getEmployee(int id)
	{
		String query="select * from employee";
        
        List<Map<String, Object>> employees =  jdbcTemplate.queryForList(query);
        if (employees!=null && !employees.isEmpty()) {
            
            for (Map<String, Object> employee : employees) {
                 
                for (Iterator<Map.Entry<String, Object>> it = employee.entrySet().iterator(); it.hasNext();) {
                    Map.Entry<String, Object> entry = it.next();
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key + " = " + value);
                }
                 
                System.out.println();
                 
            }
             
        }
		System.out.println("done");
	}


}
