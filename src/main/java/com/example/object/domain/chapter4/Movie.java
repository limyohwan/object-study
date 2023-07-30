package com.example.object.domain.chapter4;

import com.example.object.domain.chapter2.Money;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;
    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

//    public Money getFee() {
//        return fee;
//    }
//
//    public void setFee(Money fee) {
//        this.fee = fee;
//    }
//
//    public List<DiscountCondition> getDiscountConditions() {
//        return discountConditions;
//    }
//
//    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
//        this.discountConditions = discountConditions;
//    }

    public MovieType getMovieType() {
        return movieType;
    }

    // Movie 역시 내부 구현을 인터페이스에 노출 시킴
    public Money calculateAmountDiscountedFee() {
        if(movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee() {
        if(movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountedFee() {
        if(movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee;
    }

    // DiscountCondition의  PERIOD가 명칭이 변경되면 수정이 필요함, 종류가 추가되거나 삭제되면 if 문 분기가 추가되어야함
    public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
        for (DiscountCondition condition : discountConditions) {
            if(condition.getType() == DiscountConditionType.PERIOD) {
                if(condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
                    return true;
                }
            }else {
                if(condition.isDiscountable(sequence)) {
                    return true;
                }
            }
        }

        return false;
    }

//    public void setMovieType(MovieType movieType) {
//        this.movieType = movieType;
//    }
//
//    public Money getDiscountAmount() {
//        return discountAmount;
//    }
//
//    public void setDiscountAmount(Money discountAmount) {
//        this.discountAmount = discountAmount;
//    }
//
//    public double getDiscountPercent() {
//        return discountPercent;
//    }
//
//    public void setDiscountPercent(double discountPercent) {
//        this.discountPercent = discountPercent;
//    }
}
