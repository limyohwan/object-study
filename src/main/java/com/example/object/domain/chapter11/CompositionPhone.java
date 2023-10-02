package com.example.object.domain.chapter11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CompositionPhone {
    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public CompositionPhone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }

    public static void main(String[] args) {
        CompositionPhone phone = new CompositionPhone(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));
        CompositionPhone nightlyPhone = new CompositionPhone(new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)));
    }
}
