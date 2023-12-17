package com.subramanians.tablebooking;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        // Define start and end times
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(20, 0);
        int intervalMinutes = 30;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime currentTime = startTime;
        while (currentTime.isBefore(endTime) || currentTime.equals(endTime)) {
            String formattedTime = currentTime.format(formatter);
            System.out.println("Time: " + currentTime);
            currentTime = currentTime.plusMinutes(intervalMinutes);
        }
    }
}
