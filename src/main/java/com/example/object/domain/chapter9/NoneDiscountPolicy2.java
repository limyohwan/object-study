package com.example.object.domain.chapter9;

public class NoneDiscountPolicy2 implements DiscountPolicy2 {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
