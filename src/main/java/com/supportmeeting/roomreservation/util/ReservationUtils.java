package com.supportmeeting.roomreservation.util;

import org.springframework.stereotype.Component;

@Component
public class ReservationUtils {

    public int getCleanUpTime(int requiredSeats) {
        return requiredSeats + 5;
    }

}
