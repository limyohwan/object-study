package com.example.object.domain.chapter13;

import com.example.object.domain.chapter9.DiscountCondition;
import com.example.object.domain.chapter9.Money;
import com.example.object.domain.chapter9.Screening;

import java.time.LocalTime;

public class BrokenDiscountPolicy extends DiscountPolicy {

    public BrokenDiscountPolicy(DiscountCondition... conditions) {
        super(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        checkPreCondition(screening); // 기존의 사전조건
//        checkStrongerPreCondition(screening); // 더 강력한 사전조건

        Money amount = screening.getMovieFee();
//        checkPostCondition(amount); // 기존의 사후조건
//        checkStrongerPostCondition(amount); // 더 강력한 사후조건
        checkWeakerPostCondition(amount);

        return amount;
    }

    private void checkWeakerPostCondition(Money amount) {
        assert amount != null;
    }

    private void checkStrongerPreCondition(Screening screening) {
        assert screening.getStartTime().toLocalTime().isBefore(LocalTime.MIDNIGHT);
    }

    private void checkStrongerPostCondition(Money amount) {
        assert amount.isGreaterThanOrEqual(Money.wons(1000));
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
