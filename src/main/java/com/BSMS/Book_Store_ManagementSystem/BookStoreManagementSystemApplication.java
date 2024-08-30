package com.BSMS.Book_Store_ManagementSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@SpringBootApplication
public class BookStoreManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreManagementSystemApplication.class, args);
	}

}
