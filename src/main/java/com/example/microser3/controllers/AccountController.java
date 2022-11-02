package com.example.microser3.controllers;

import com.example.microser3.dto.AccountRequestDTO;
import com.example.microser3.entities.BankAccount;
import com.example.microser3.repository.BankAccountRepository;
import com.example.microser3.services.AccountImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountController {

    private AccountImpl account;
    private BankAccountRepository bankAccountRepository;

    @GetMapping("/Accounts")
    public List<BankAccount> listAccount()
    {
        return account.getBankAccounts();
    }
    @GetMapping("/Accounts/{id}")
    public BankAccount AccountById(@PathVariable String id)
    {
        return account.getBankAccountById(id);
    }
    @PostMapping("Accounts")
    public BankAccount saveAccount(@RequestBody AccountRequestDTO accountRequestDTO)
    {
        return account.saveBankAccount(accountRequestDTO);
    }
    @PutMapping("Accounts/{id}")
    public BankAccount updateAccount(@PathVariable String id,@RequestBody BankAccount bankAccount)
    {
     return  account.updateBankAccount(id,bankAccount);
    }

    @DeleteMapping("Accounts/{id}")
    public void deleteAccount(@PathVariable String id)
    {
        account.deleteBankAccount(id);
    }

}
