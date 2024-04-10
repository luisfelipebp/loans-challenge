package com.luisfelipebp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loans {

    private String customer;

    private List<Loan> ListLoans = new ArrayList<>();
}
