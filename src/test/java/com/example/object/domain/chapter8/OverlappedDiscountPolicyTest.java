package com.example.object.domain.chapter8;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OverlappedDiscountPolicyTest {

    @Test
    void amountDiscountPolicy() {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000L),
                new OverlappedDiscountPolicy(
                        new AmountDiscountPolicy(Money.wons(800L),
                                new SequenceCondition(1),
                                new SequenceCondition(10),
                                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))),
                        new PercentDiscountPolicy(0.1,
                                new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                                new SequenceCondition(2),
                                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59)))
                ));

        assertThat(avatar.getFee().isGreaterThanOrEqual(Money.wons(10000L))).isTrue();
    }
}