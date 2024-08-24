package com.example.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpenseUser extends BaseModel{
    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User user;
    private Double amount;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;
}
