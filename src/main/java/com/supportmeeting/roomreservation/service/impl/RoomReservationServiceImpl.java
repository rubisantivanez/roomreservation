package com.supportmeeting.roomreservation.service.impl;

import com.supportmeeting.roomreservation.dto.AvailableRoomDto;
import com.supportmeeting.roomreservation.dto.ReservationRequestDto;
import com.supportmeeting.roomreservation.repository.MeetingRoomRepository;
import com.supportmeeting.roomreservation.service.RoomReservationService;
import com.supportmeeting.roomreservation.translate.AvailableResponseTranslate;
import com.supportmeeting.roomreservation.translate.IAvailableRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomReservationServiceImpl implements RoomReservationService {

    @Autowired
    private MeetingRoomRepository meetingRoomRepository;

    @Autowired
    private AvailableResponseTranslate availableResponseTranslate;

    @Override
    public List<AvailableRoomDto> getAvailableRoomsByAllocation(ReservationRequestDto reservationRequest) {
        List<IAvailableRoom> response;

        if (reservationRequest.getBuildingName() == null) {
            response = meetingRoomRepository.findAvailableRooms(reservationRequest.getAttendeesNumber());
        } else {
            response = meetingRoomRepository.findAvailableRoomsWithBuilding(reservationRequest.getAttendeesNumber(),
                    reservationRequest.getBuildingName());
        }
        return response.stream().map(k -> availableResponseTranslate.translateTo(k)).collect(Collectors.toList());
    }

}
