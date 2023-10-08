package com.example.object.domain.chapter14;

import com.example.object.domain.chapter11.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
