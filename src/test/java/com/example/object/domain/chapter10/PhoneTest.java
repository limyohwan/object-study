package com.example.object.domain.chapter10;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void phone() {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
        phone.call(new Call(LocalDateTime.of(2018, 1, 1, 12, 10, 0),
                            LocalDateTime.of(2018, 1, 1, 12, 11, 0)));
        phone.call(new Call(LocalDateTime.of(2018, 1, 2, 12, 10, 0),
                            LocalDateTime.of(2018, 1, 2, 12, 11, 0)));

        Money money = phone.calculateFee();
        Assertions.assertThat(money.getAmount().intValue()).isEqualTo(Money.wons(60).getAmount().intValue());
    }
}