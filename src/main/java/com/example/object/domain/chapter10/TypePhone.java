package com.example.object.domain.chapter10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TypePhone {
    private static final int LATE_NIGHT_HOUR = 22;
    enum PhoneType {REGULAR, NIGHTLY}

    private PhoneType type;

    private Money amount;
    private Money regularAmount;
    private Money nightlyAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public TypePhone(Money amount, Duration seconds) {
        this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
    }

    public TypePhone(Money regularAmount, Money nightlyAmount, Duration seconds) {
        this(PhoneType.NIGHTLY, Money.ZERO, regularAmount, nightlyAmount, seconds);
    }

    public TypePhone(PhoneType type, Money amount, Money regularAmount, Money nightlyAmount, Duration seconds) {
        this.type = type;
        this.amount = amount;
        this.regularAmount = regularAmount;
        this.nightlyAmount = nightlyAmount;
        this.seconds = seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if(type == PhoneType.REGULAR) {
                result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else {
                if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                    result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                } else {
                    result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                }
            }
        }

        return result;
    }
}
