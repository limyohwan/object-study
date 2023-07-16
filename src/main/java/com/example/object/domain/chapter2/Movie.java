package com.example.object.domain.chapter2;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        // 할인 정책이 없는 경우는 예외 케이스로 취급되기 때문에 지금까지 일관성 있던 협력 방식이 무너지게됨
        if(discountPolicy == null) {
            return fee;
        }
        // 업캐스팅 = 자식 클래스가 부모 클래스를 대신하는 것
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
