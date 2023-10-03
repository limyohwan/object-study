package com.example.object.domain.chapter11;

public abstract class BasicRatePolicy implements RatePolicy {
    @Override
    public Money calculateFee(CompositionPhone phone) {
        Money result = Money.ZERO;

        for (Call call : phone.getCalls()) {
            result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected abstract Money calculateCallFee(Call call);
}
