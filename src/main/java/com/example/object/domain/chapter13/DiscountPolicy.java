package com.example.object.domain.chapter13;

import com.example.object.domain.chapter9.DiscountCondition;
import com.example.object.domain.chapter9.Money;
import com.example.object.domain.chapter9.Screening;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    // 차이에 의한 프로그래밍 = 부모 클래스와 다른 부분만을 추가하여 새로운 클래스를 쉽고 빠르게 만드는 방법
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        checkPreCondition(screening);

        Money amount = Money.ZERO;
        for (DiscountCondition each : conditions) {
            if(each.isSatisfiedBy(screening)) {
                amount = getDiscountAmount(screening);
                checkPostCondition(amount);
                return amount;
            }
        }

        amount = screening.getMovieFee();
        checkPostCondition(amount);
        return amount;
    }

    protected void checkPreCondition(Screening screening) {
        assert screening != null && screening.getStartTime().isAfter(LocalDateTime.now());
    }

    protected void checkPostCondition(Money amount) {
        assert amount != null && amount.isGreaterThanOrEqual(Money.ZERO);
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
