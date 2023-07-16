package com.example.object.domain.chapter2;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTest {

    @Test
    void amountDiscountPolicy() {
        // Movie 인스턴스는 실행시점에 AmountDiscountPolicy 클래스 인스턴스에 의존
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000L),
                new AmountDiscountPolicy(Money.wons(800L),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));

        assertThat(avatar.getFee().isGreaterThanOrEqual(Money.wons(10000L))).isTrue();
    }

    @Test
    void percentDiscountPolicy() {
        // Movie 인스턴스는 실행시점에 PercentDiscountPolicy 클래스 인스턴스에 의존
        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000L),
                new PercentDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))));

        assertThat(titanic.getFee().isGreaterThanOrEqual(Money.wons(11000L))).isTrue();
    }

    @Test
    void noneDiscountPolicy() {
        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000L),
                new NoneDiscountPolicy());

        assertThat(starWars.getFee().isGreaterThanOrEqual(Money.wons(10000L))).isTrue();
    }

}