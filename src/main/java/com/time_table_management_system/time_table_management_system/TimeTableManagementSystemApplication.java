package com.time_table_management_system.time_table_management_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimeTableManagementSystemApplication {

	private  static  final Logger LOGGER = LoggerFactory.getLogger(TimeTableManagementSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TimeTableManagementSystemApplication.class, args);

		LOGGER.info("All method excuted successfully");
	}

}
