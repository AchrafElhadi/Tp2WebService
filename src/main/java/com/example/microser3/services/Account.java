package com.example.microser3.services;

import com.example.microser3.dto.AccountRequestDTO;
import com.example.microser3.entities.BankAccount;

import java.util.List;

public interface Account {
    List<BankAccount> getBankAccounts();
    BankAccount getBankAccountById(String id);
    BankAccount saveBankAccount(AccountRequestDTO accountRequestDTO);
    BankAccount updateBankAccount(String id,BankAccount BankAccount);
    void deleteBankAccount(String id);
}
