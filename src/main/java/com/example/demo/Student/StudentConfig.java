package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student samrat = Student.builder()
                    .name("samrat")
                    .dob(LocalDate.of(2001, Month.MARCH,28))
                    .email("samrat@gmail.com")
                    .build();

            repository.saveAll(List.of(samrat));
        };
    }
}
