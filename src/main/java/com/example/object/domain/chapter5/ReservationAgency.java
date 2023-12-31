package com.example.object.domain.chapter5;

import com.example.object.domain.chapter2.Money;
import com.example.object.domain.chapter4.Customer;

public class ReservationAgency {
//    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
//        boolean discountable = checkDiscountable(screening);
//        Money fee = calculateFee(screening, discountable, audienceCount);
//        return createReservation(screening, customer, audienceCount, fee);
//    }
//
//    private boolean checkDiscountable(Screening screening) {
//        return screening.getMovie().getDiscountConditions().stream()
//                .anyMatch(condition -> isDiscountable(condition, screening));
//    }
//
//    private boolean isDiscountable(DiscountCondition condition, Screening screening) {
//        if(condition.getType() == DiscountConditonType.PERIOD) {
//            return isSatisfiedByPeriod(condtion, screening);
//        }
//
//        return isSatisfiedBySequence(condtion, screening);
//    }
//
//    private boolean isSatisfiedByPeriod(DiscountCondition condition, Screening screening) {
//        return screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
//                condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
//                condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
//    }
//
//    private boolean isSatisfiedBySequence(DiscountCondition condition, Screening screening) {
//        return condition.getSequence() == screening.getSequence();
//    }
//
//    private boolean checkDiscountable(Screening screening) {
//        return screening.getMovie().getDiscountConditions().stream()
//                .anyMatch(condition -> condition.isDiscountable(screening));
//    }
//
//    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
//        if(discountable) {
//            return screening.getMovie().getFee()
//                    .minus(calculateDiscountedFee(screening.getMovie()))
//                    .times(audienceCount);
//        }
//
//        return screening.getMovie().getFee().times(audienceCount);
//    }
//
//    private Money calculateDiscountedFee(Movie movie) {
//        switch (movie.getMovieType()) {
//            case AMOUNT_DISCOUNT:
//                discountAmount = moive.getDiscountAmount();
//                break;
//            case PERCENT_DISCOUNT:
//                discountAmount = movie.getFee().times(movie.getDiscountPercent());
//                break;
//            case NONE_DISCOUNT:
//                discountAmount = Money.ZERO;
//                break;
//        }
//    }
//
//    private Money calculateAmountDiscountedFee(Movie movie) {
//        return movie.getDiscountAmount();
//    }
//
//    private Money calculatePercentDiscountedFee(Movie movie) {
//        return movie.getFee().times(movie.getDiscountPercent());
//    }
//
//    private Money calculateNoneDiscountedFee(Movie movie) {
//        return Money.ZERO;
//    }
//
//    private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
//        return new Reservation(customer, screening, fee, audienceCount);
//    }

}
