package com.example.microser3.entities;


import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = BankAccount.class,name = "p1")
public interface AccountProjection {
    public Date getCreated();
    public Double getBalance();
}
