package com.example.object.domain.chapter11;

public interface RatePolicy {
    Money calculateFee(CompositionPhone phone);
}
