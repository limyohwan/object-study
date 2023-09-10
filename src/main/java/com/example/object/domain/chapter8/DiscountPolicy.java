package com.example.object.domain.chapter8;

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
        for (DiscountCondition each : conditions) {
            if(each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    public void switchConditions(List<DiscountCondition> conditions) {
        this.conditions = conditions;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
