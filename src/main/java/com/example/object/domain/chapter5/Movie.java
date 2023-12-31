package com.example.object.domain.chapter5;

import com.example.object.domain.chapter2.Money;

import java.time.Duration;
import java.util.List;

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
//    private List<OldDiscountCondition> discountConditions;
    private List<DiscountCondition> discountConditions;
//    private MovieType movieType;
//    private Money discountAmount;
//    private double discountPercent;
//    private List<PeriodCondition> periodConditions;
//    private List<SequenceCondition> sequenceConditions;


    public Movie(String title, Duration runningTime, Money fee, List<DiscountCondition> discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = discountConditions;
    }

    public Money calculateMovieFee(Screening screening) {
        if(isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

//    private boolean isDiscountable(Screening screening) {
//        return discountConditions.stream()
//                .anyMatch(condition -> condition.isSatisfiedBy(screening));
//    }

//    private boolean isDiscountable(Screening screening) {
//        return checkPeriodConditions(screening) || checkSequenceConditions(screening);
//    }
//
//    private boolean checkPeriodConditions(Screening screening) {
//        return periodConditions.stream()
//                .anyMatch(condition -> condition.isSatisfiedBy(screening));
//    }
//
//    private boolean checkSequenceConditions(Screening screening) {
//        return sequenceConditions.stream()
//                .anyMatch(condition -> condition.isSatisfiedBy(screening));
//    }

    abstract protected Money calculateDiscountAmount();

    protected Money getFee() {
        return fee;
    }

//    private Money calculateDiscountAmount() {
//        switch (movieType) {
//            case AMOUNT_DISCOUNT:
//                return calculateAmountDiscountAmount();
//            case PERCENT_DISCOUNT:
//                return calculatePercentDiscountAmount();
//            case NONE_DISCOUNT:
//                return calculateNoneDiscountAmount();
//        }
//
//        throw new IllegalStateException();
//    }
//
//    private Money calculateAmountDiscountAmount(){
//        return discountAmount;
//    }
//
//    private Money calculatePercentDiscountAmount() {
//        return fee.times(discountPercent);
//    }
//
//    private Money calculateNoneDiscountAmount() {
//        return Money.ZERO;
//    }
}
