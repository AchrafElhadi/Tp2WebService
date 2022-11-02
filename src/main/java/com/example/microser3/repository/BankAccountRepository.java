package com.example.microser3.repository;

import com.example.microser3.entities.BankAccount;
import com.example.microser3.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
 @RestResource(path = "/bytype")
    List<BankAccount> findByType(@Param("type") AccountType accountType);
}
