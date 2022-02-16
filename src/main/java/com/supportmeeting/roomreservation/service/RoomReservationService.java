package com.supportmeeting.roomreservation.service;

import com.supportmeeting.roomreservation.dto.AvailableRoomDto;
import com.supportmeeting.roomreservation.dto.ReservationRequestDto;

import java.util.List;

public interface RoomReservationService {

    List<AvailableRoomDto> getAvailableRoomsByAllocation(ReservationRequestDto reservationRequest);

}
