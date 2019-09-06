package com.IBm._jdbc_annotation.beans;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

@Component(value = "dataSource")
public class DataSource extends BasicDataSource {
	
	@PostConstruct
	public void DataSourceCreate(){
		setDriverClassName("com.mysql.jdbc.Driver");
		setUrl("jdbc:mysql://localhost:3306/hr");
		setUsername("root");
		setPassword("root");
	}

	
	
	
	
}
