package com.example.object.domain.chapter9;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Client {
    public Money getAvatarFee() {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000L),
                new AmountDiscountPolicy(Money.wons(800L),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));

        return avatar.getFee();
    }
}
