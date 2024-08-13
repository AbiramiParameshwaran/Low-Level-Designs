package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private PaymentMode paymentmode;
    private PaymentStatus paymentStatus;
    private  String referenceNumber;
    private Long amount;
}
