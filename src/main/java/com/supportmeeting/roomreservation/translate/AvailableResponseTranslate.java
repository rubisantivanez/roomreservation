package com.supportmeeting.roomreservation.translate;

import com.supportmeeting.roomreservation.dto.AvailableRoomDto;
import com.supportmeeting.roomreservation.util.ReservationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AvailableResponseTranslate implements Translate<AvailableRoomDto, IAvailableRoom> {

    @Autowired
    private ReservationUtils reservationUtils;

    @Override
    public AvailableRoomDto translateTo(IAvailableRoom input) {
        return AvailableRoomDto.builder()
                .roomId(input.getRoomId())
                .roomName(input.getRoomName())
                .cleanUpMinutes(reservationUtils.getCleanUpTime((input.getMaxAllocation())))
                .build();
    }
}
