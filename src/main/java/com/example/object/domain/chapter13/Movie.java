package com.example.object.domain.chapter13;

import com.example.object.domain.chapter9.DiscountPolicy;
import com.example.object.domain.chapter9.Money;
import com.example.object.domain.chapter9.Screening;

import java.io.InvalidObjectException;
import java.time.Duration;
import java.time.LocalDateTime;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private com.example.object.domain.chapter9.DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, com.example.object.domain.chapter9.DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        if(screening == null || screening.getStartTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("invalid");
        }
        // 업캐스팅 = 자식 클래스가 부모 클래스를 대신하는 것
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
    
    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
