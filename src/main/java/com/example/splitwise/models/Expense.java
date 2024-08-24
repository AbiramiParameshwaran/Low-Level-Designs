package com.example.splitwise.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String description;
    private double amount;
    private String createdBy;
    @OneToMany(mappedBy = "expense")
    private List<ExpenseUser> expenseUsers;
}
