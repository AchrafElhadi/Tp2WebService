package com.example.microser3;

import com.example.microser3.entities.BankAccount;
import com.example.microser3.enums.AccountType;
import com.example.microser3.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Microser3Application {

    public static void main(String[] args) {
        SpringApplication.run(Microser3Application.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository)
    {
        return args -> {
            for(int i=0;i<5;i++) {
                BankAccount bankAccount = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .balance(Math.random() * 10000)
                        .created(new Date())
                        .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                        .currency("MAD")
                        .build();


                bankAccountRepository.save(bankAccount);
            }
        };
    }
}
