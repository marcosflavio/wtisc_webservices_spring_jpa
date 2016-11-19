package br.com.ufc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
@EntityScan(basePackages = {
        "br.com.ufc.model", "br.com.ufc.repository", "br.com.ufc.service", "br.ufc.com.controller"
        })
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Hello Spring!");
		
	}
}
