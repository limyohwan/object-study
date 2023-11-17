package com.example.object.domain.appendixB;

import com.example.object.domain.appendixA.BookStall;
import com.example.object.domain.appendixA.Customer;
import com.example.object.domain.appendixA.MagazineStore;

import java.math.BigDecimal;

public class AppendixBMain {
    public static void main(String[] args) {

        calculate(new SalariedEmployee("yohwan", new Money(BigDecimal.ONE)), 0.01);
        calculate(new HourlyEmployee("yohwan", new Money(BigDecimal.ONE), 3), 0.01);
    }

    public static Money calculate(Employee employee, double taxRate) {
        return employee.calculatePay(taxRate);
    }
}
