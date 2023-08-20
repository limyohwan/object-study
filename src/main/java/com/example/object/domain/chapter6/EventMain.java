package com.example.object.domain.chapter6;

import org.springframework.util.Assert;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EventMain {
    public static void main(String[] args) {
        Event meeting = new Event("회의", LocalDateTime.of(2019, 5, 9, 10, 30), Duration.ofMinutes(30L));

        RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30L));

        Assert.isTrue(!meeting.isSatisfied(schedule));
        Assert.isTrue(meeting.isSatisfied(schedule));
    }
}
