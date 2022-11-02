package com.example.microser3.dto;

import com.example.microser3.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class AccountRequestDTO {
    private String currency;
    private Double balance;
    private AccountType type;
}
