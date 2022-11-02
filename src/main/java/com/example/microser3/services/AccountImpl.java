package com.example.microser3.services;

import com.example.microser3.dto.AccountRequestDTO;
import com.example.microser3.entities.BankAccount;
import com.example.microser3.mappers.Mappers;
import com.example.microser3.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountImpl implements Account {
    BankAccountRepository bankAccountRepository;
    Mappers mappers;
    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public BankAccount getBankAccountById(String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"));
    }

    @Override
    public BankAccount saveBankAccount(AccountRequestDTO accountRequestDTO) {


        BankAccount bankAccount=  mappers.convertRequestToAccount(accountRequestDTO);

        System.out.println(bankAccount.getCurrency());
        return  bankAccountRepository.save(bankAccount);

    }

    @Override
    public BankAccount updateBankAccount(String id, BankAccount bankAccount) {
        BankAccount acc=getBankAccountById(id);

        if(bankAccount.getBalance()!=null)   acc.setBalance(bankAccount.getBalance());
        if(bankAccount.getCurrency()!=null)  acc.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getType()!=null)  acc.setType(bankAccount.getType());

        return bankAccountRepository.save(acc);
    }

    @Override
    public void deleteBankAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
