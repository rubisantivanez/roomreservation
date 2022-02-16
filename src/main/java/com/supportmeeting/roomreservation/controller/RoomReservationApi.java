package com.supportmeeting.roomreservation.controller;

import com.supportmeeting.roomreservation.dto.AvailableRoomDto;
import com.supportmeeting.roomreservation.dto.ReservationRequestDto;
import com.supportmeeting.roomreservation.service.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/room_reservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomReservationApi {

    @Autowired
    private RoomReservationService roomReservationService;

    @PostMapping("/available_rooms")
    @ResponseBody
    public ResponseEntity<List<AvailableRoomDto>> availableRooms(@RequestBody ReservationRequestDto reservationRequestDto) {
        List<AvailableRoomDto> availableRooms = roomReservationService.getAvailableRoomsByAllocation(reservationRequestDto);
        return new ResponseEntity<>(availableRooms, HttpStatus.OK);
    }

}
