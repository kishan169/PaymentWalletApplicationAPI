package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
public class PaymentWalletAppapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentWalletAppapiApplication.class, args);
	}

}
