package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AlbumEurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(AlbumEurekaApplication.class, args);
	}
}