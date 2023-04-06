package com.sandrayang.vocabbuilderspringboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// password: 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
@SpringBootApplication
public class VocabBuilderSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(VocabBuilderSpringBootApplication.class, args);

	}
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
