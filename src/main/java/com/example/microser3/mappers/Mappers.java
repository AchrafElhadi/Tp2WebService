package com.example.microser3.mappers;

import com.example.microser3.dto.AccountRequestDTO;
import com.example.microser3.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class Mappers {

    public BankAccount convertRequestToAccount(AccountRequestDTO accountRequestDTO)
    {
        BankAccount bankAccount=new BankAccount();
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreated(new Date());
        BeanUtils.copyProperties(accountRequestDTO,bankAccount);

        return bankAccount;
    }
}
