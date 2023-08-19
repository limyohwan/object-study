package com.example.object.domain.chapter6;

import java.time.Duration;
import java.time.LocalDateTime;

public class EventMain {
    public static void main(String[] args) {
        Event meeting = new Event("회의", LocalDateTime.of(2019, 5, 8, 10, 30), Duration.ofMinutes(30L));
    }
}
