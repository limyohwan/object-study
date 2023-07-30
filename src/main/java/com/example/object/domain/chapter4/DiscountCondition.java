package com.example.object.domain.chapter4;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    // getType을 통해 내부에 DiscountconditionType이 포함되어 있다는 정보를 노출시킴
    public DiscountConditionType getType() {
        return type;
    }

    // 속성정보에 DayOfWeek와 LocalTime을 받는다는 것을 노출시킴
    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if(type != DiscountConditionType.PERIOD) {
            throw new IllegalStateException();
        }

        return this.dayOfWeek.equals(dayOfWeek) &&
                this.startTime.compareTo(time) <= 0 &&
                this.endTime.compareTo(time) >= 0;
    }

    public boolean isDiscountable(int sequence) {
        if(type != DiscountConditionType.SEQUENCE) {
            throw new IllegalStateException();
        }

        return this.sequence == sequence;
    }

//    public void setType(DiscountConditionType type) {
//        this.type = type;
//    }
//
//    public int getSequence() {
//        return sequence;
//    }
//
//    public void setSequence(int sequence) {
//        this.sequence = sequence;
//    }
//
//    public DayOfWeek getDayOfWeek() {
//        return dayOfWeek;
//    }
//
//    public void setDayOfWeek(DayOfWeek dayOfWeek) {
//        this.dayOfWeek = dayOfWeek;
//    }
//
//    public LocalTime getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(LocalTime startTime) {
//        this.startTime = startTime;
//    }
//
//    public LocalTime getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(LocalTime endTime) {
//        this.endTime = endTime;
//    }
}
